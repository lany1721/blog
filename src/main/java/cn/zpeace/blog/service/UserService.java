package cn.zpeace.blog.service;


import cn.zpeace.blog.pojo.User;

public interface UserService {

    User findUser(String username,String password) throws Exception;

    User getUserById(Integer userId);

    Integer updateUserInfo(User user);

    User checkPassword(Integer userId,String password);

    Integer updatePassword(Integer userId,String password);

    String getIntroduceAndConvert(Integer userId);

    Boolean isUserExist(String username);
}
