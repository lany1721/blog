package cn.zpeace.blog.controller.admin;


import cn.zpeace.blog.pojo.User;
import cn.zpeace.blog.service.UserService;
import cn.zpeace.blog.util.MyBlogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {


    @Autowired
    UserService userService;

    @Value("${parentDirPath}")
    private String parentDirPath;

    @Value("${fileSever}")
    private String fileSever;

    @GetMapping({"/index", "/", ""})
    public String index() {
        return "admin/index";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) throws Exception {

        log.info("管理员尝试进行登录,用户名为:{} ,密码为:{}", username, password);

        Boolean userExist = userService.isUserExist(username);
        if (userExist) {
            User user = userService.findUser(username, password);
            if (user != null) {
                session.setAttribute("user", user);
                log.info("登录成功,用户名为:{}", user.getUsername());
                return "redirect:/admin/";
            } else {
                log.info("登录失败,失败原因:用户名或者密码错误");
                model.addAttribute("message","用户名或者密码错误");
                return "admin/login";
            }
        } else {
            log.info("登录失败,失败原因:用户不存在");
            model.addAttribute("message","用户不存在");
            return "admin/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.removeAttribute("user");

        return "admin/login";
    }

    @GetMapping("/user")
    public String userInfo(HttpSession session,Model model){

        User sessionUser = (User) session.getAttribute("user");

        User user = userService.getUserById(sessionUser.getId());

        model.addAttribute("user",user);

        return "admin/info";
    }


    @PostMapping("/user")
    public String updateInfo(User user, @RequestParam(value = "avatar-img",required = false)MultipartFile file,
                                HttpSession session){

        if (!file.isEmpty()) {
            //用户目录
            String userDirectory = MyBlogUtil.getUserDirectory(session);

            //文件重命名
            String newFileName = MyBlogUtil.getNewFileName(file.getOriginalFilename());
            log.info("用户目录为{},文件名为{}",userDirectory,newFileName);

            //设置头像的保存位置
            String avatarPath = parentDirPath + userDirectory + "avatar" + File.separator;
            File avatarDir = new File(avatarPath);

            if (!avatarDir.exists()){
                avatarDir.mkdirs();
            }
            File avatarFile = new File(avatarPath + newFileName);
            try {
                file.transferTo(avatarFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String avatorUrl =fileSever + userDirectory.replace("\\","/")+ "avatar/" + newFileName;

            user.setAvatar(avatorUrl);
        }


        userService.updateUserInfo(user);

        return "redirect:/admin/user";
    }


    @PutMapping("/user")
    public String updatePassword(Integer userId, String oldPassword,
                                 String newPassword,RedirectAttributes attributes){


        User checkUser = userService.checkPassword(userId, oldPassword);

        if(checkUser!=null){
            userService.updatePassword(userId,newPassword);
            attributes.addFlashAttribute("success",true);
        }else {
            attributes.addFlashAttribute("success",false);
        }


        return "redirect:/admin/user";
    }







}
