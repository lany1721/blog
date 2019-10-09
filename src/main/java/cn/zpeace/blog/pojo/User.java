package cn.zpeace.blog.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String uuid;

    private String username;

    private String nickname;

    private String email;

    private String password;

    private String avatar;

    private String introduce;

}
