package cn.zpeace.blog.util;


import cn.zpeace.blog.pojo.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class MyBlogUtil {


    public static String getStatusCode(Integer code){
        if (code != null && code > 0){
            return "200";
        }else {
            return "500";
        }
    }
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("X-Real-IP") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("X-Real-IP");
    }

    public static String getNewFileName(String fileName){

        String suffixName = fileName.substring(fileName.lastIndexOf(".")); //文件格式

        //重命名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();

        return newFileName;
    }

    public static String getUserDirectory(HttpSession session){
        User user = (User) session.getAttribute("user");

        String userPath = "user" + File.separator +  user.getUuid() + File.separator;

        return userPath;
    }
}
