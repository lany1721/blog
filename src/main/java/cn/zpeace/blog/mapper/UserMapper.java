package cn.zpeace.blog.mapper;

import cn.zpeace.blog.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select id from t_user where id = #{userId} and password = #{password}")
    User getUserByIdAndPassword(Integer userId,String password);

    @Update("update t_user set password = #{password} where id = #{userId}")
    Integer updatePassword(Integer userId, String password);

    @Select("select introduce from t_user where id = #{userId}")
    String getIntroduce(Integer userId);
}

