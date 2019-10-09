package cn.zpeace.blog;

import cn.zpeace.blog.mapper.BlogMapper;
import cn.zpeace.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    UserMapper userMapper;



    @Autowired
    BlogMapper blogMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void login() throws Exception {
//        User user = new User();
//        user.setNickname("skiu");
//        user.setEmail("1106124433@qq.com");
//        user.setUuid(UuidUtil.getUuid());
//        user.setUsername("1106124433");
//        user.setAvatar("132");
//        user.setPassword(Md5Util.encodeByMd5("980104"));
//        userMapper.insert(user);

    }

    @Test
    public void getAll(){

    }
}
