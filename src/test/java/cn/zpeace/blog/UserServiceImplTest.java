/*
package cn.zpeace.blog;

import cn.zpeace.blog.pojo.User;
import cn.zpeace.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setAvatar("http://localhost/user/ceacf0537dde42fc9abde14e166d92d7/avatar/2019100814082830.jpg");
        user.setId(5);
        user.setNickname("钟瓶镜");
        userService.updateUserInfo(user);
    }

    @Test
    public void checkPassword() {
        User user = userService.checkPassword(5, "9801041");
        System.out.println(user);
    }
}*/
