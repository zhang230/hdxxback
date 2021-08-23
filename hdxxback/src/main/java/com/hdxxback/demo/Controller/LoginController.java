package com.hdxxback.demo.Controller;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.Impl.UserServiceImpl;
import com.hdxxback.demo.Utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/userlogin")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @CrossOrigin
    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
    @CrossOrigin
    @PostMapping("/login")
    public List<Map<String,Object > > userLogin(@RequestParam(value = "verifyCode") String verifyCode,@RequestBody User user,HttpSession session){
        ResultData<User> res1 = userService.userNameRepeat(user);
        /*
         * 这里验证码 如果存入session  那么因为每次请求的sessionID不同，所以session在验证码生成的session
         * 的sessionID和当前的sessionID不同，所以我才用application返回来解决。
         * */
        String sv = (String) session.getServletContext().getAttribute("verify_code");
        Map<String,Object> mp1 = new HashMap<>();
        Map<String,Object> mp2 = new HashMap<>();
        mp1.put("data1",res1);
        mp2.put("sessionID",session.getId());
        ResultData<User> res2 = new ResultData<User>(200,null,null);
        if(verifyCode.equals(sv)){//如果验证码正确
            res2.setMsg("验证码正确");
        }else {
            res2.setMsg("验证码错误");
        }
        mp2.put("verifyCode",res2);
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        maps.add(mp1);
        maps.add(mp2);
        return maps;
    }
    /*
     *  生成验证码图片返回到前端，并且将验证码的code存在session中
     * */
    @CrossOrigin
    @RequestMapping("/verifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException, IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        session.getServletContext().setAttribute("verify_code", text);
//        System.out.println("验证码生成了:   "+text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
