package com.hdxxback.demo.Config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 允许跨域请求
 * @author zsh
 *
 */
public class FilterConfig implements HandlerInterceptor {
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)
            throws Exception {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));//支持跨域请求
        response.setHeader("Access-Control-Allow-Methods",  "POST, GET, PATCH, DELETE, PUT, OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");//是否支持cookie跨域
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");//Origin, X-Requested-With, Content-Type, Accept,Access-Token
//        String uri = request.getRequestURI();
//        HttpSession session = request.getSession();
//        String user = (String)session.getAttribute("usersessionid");
//        if("/user/login".equalsIgnoreCase(uri))return true;
////        System.out.println("拦截器"+user);
//        if(user == null) {
//            return false;
//        }
        return true;
    }
}
