package cn.zpeace.blog.service.impl;

import cn.zpeace.blog.mapper.UserMapper;
import cn.zpeace.blog.pojo.User;
import cn.zpeace.blog.service.UserService;


import cn.zpeace.blog.util.MarkdownUtil;
import cn.zpeace.blog.util.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(String username,String password) throws Exception {

        return userMapper.selectOne(new QueryWrapper<User>()
        .eq("username",username).eq("password", Md5Util.encodeByMd5(password)));
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public Integer updateUserInfo(User user) {
        return userMapper.update(user,new UpdateWrapper<User>().eq("id",user.getId()));
    }

    @Override
    public User checkPassword(Integer userId, String password) {

        return userMapper.getUserByIdAndPassword(userId,Md5Util.encodeByMd5(password));
    }

    @Override
    public Integer updatePassword(Integer userId, String password) {
        return userMapper.updatePassword(userId,Md5Util.encodeByMd5(password));
    }

    @Override
    public String getIntroduceAndConvert(Integer userId) {

        String introduce = userMapper.getIntroduce(userId);
        if (introduce == null) {
            return "";
        }

        return MarkdownUtil.markdownToHtmlExtensions(introduce);
    }

    @Override
    public Boolean isUserExist(String username) {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return user != null;
    }
}
