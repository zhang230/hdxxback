package com.hdxxback.demo.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProduceSrcPath {
    //    windows  写入本地的数据
    private static String UPLOADED_FOLDER = "C://springboot//";
    private static String UPLOADED_VIDEO_FOLDER = "D:/Tomcat服务器/apache-tomcat-8.0.30/webapps/ROOT/src/advisor/upload/video/";
    private static String UPLOADED_IMAGE_FOLDER="D:/Tomcat服务器/apache-tomcat-8.0.30/webapps/ROOT/src/advisor/upload/image/";

    //插入数据库的数据
    private static String DB_UPLOADED_VIDEO_FOLDER="http://localhost:8080/src/advisor/upload/video/";
    private static String DB_UPLOADED_IMAGE_FOLDER="http://localhost:8080/src/advisor/upload/image/";


//    Linux
//    private static String UPLOADED_FOLDER = "/home/sx/springboot/";
//    private static String UPLOADED_VIDEO_FOLDER = "/home/sx/advisor/upload/video/";
//    private static String UPLOADED_IMAGE_FOLDER="/home/sx/advisor/upload/image/";

    public static String savePathAndProducePath(MultipartFile file){
        String pathOnServer="";
        if(file.isEmpty()){
            System.out.println("文件为空");
            return ""; //redirect:
        }
        int begin = file.getOriginalFilename().indexOf(".");
        int last=file.getOriginalFilename().length();
        String end_filename="";
        //获得文件后缀名
        String fileType=file.getOriginalFilename().substring(begin+1,last);
        String pathPrefix=""; //保存文件的路径前缀
        String DBpathPrefix="";//插入数据库的文件路径前缀
        String DBpathOnServer="";
        try {
            byte[] bytes =file.getBytes();
            String fileNameNew =file.getOriginalFilename();
            int dotLocation = fileNameNew.lastIndexOf('.');
            //文件名，用日期命名保证唯一
            fileNameNew = fileNameNew.substring(0,dotLocation)
                    + (new SimpleDateFormat("_yyyyMMdd-HHmmss-SSS").format(new Date()))
                    + fileNameNew.substring(dotLocation);
            end_filename=fileNameNew;
            if(fileType.equalsIgnoreCase("mp4")||fileType.equalsIgnoreCase("ogg")
                    ||fileType.equalsIgnoreCase("flv")||fileType.equalsIgnoreCase("avi")
                    ||fileType.equalsIgnoreCase("wmv")||fileType.equalsIgnoreCase("rmvb")){
                pathPrefix=UPLOADED_VIDEO_FOLDER;
                DBpathPrefix=DB_UPLOADED_VIDEO_FOLDER;
            }else if(fileType.equalsIgnoreCase("jpeg")||fileType.equalsIgnoreCase("jpg")||fileType.equalsIgnoreCase("png")){
                pathPrefix=UPLOADED_IMAGE_FOLDER;
                DBpathPrefix=DB_UPLOADED_IMAGE_FOLDER;
            }else{
                return null;
            }
            pathOnServer=pathPrefix+end_filename;
            Path path= Paths.get(pathOnServer);
            DBpathOnServer=DBpathPrefix+end_filename;
            //写入本地文件
            Files.write(path,bytes);

        } catch (IOException e) {
            e.printStackTrace();
            pathOnServer="";
        }
        System.out.println(pathOnServer);
        return DBpathOnServer;
    }
}
