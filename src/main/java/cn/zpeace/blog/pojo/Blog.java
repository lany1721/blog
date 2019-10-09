package cn.zpeace.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.thymeleaf.util.StringUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_blog")
public class Blog {

    @TableId(type = IdType.AUTO)
    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private Integer blogView;

    private String blogType;

    private String blogBrief;

   private Boolean published;

    private Boolean appreciation;

    private Boolean copyright;

    private Boolean comment;

    private Date createTime;

    private Date updateTime;

    private Integer categoryId;

    private Integer userId;

    @TableField(exist = false)
    private List<Tag> tags;

    @TableField(exist = false)
    private List<Integer> tagIds;

    @TableField(exist = false)
    private Category category;

    @TableField(exist = false)
    private User user;


    public String getStringTagIds(){
        List<Tag> tags = getTags();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tags.size(); i++) {
            if (i == tags.size()-1) {
                sb.append(tags.get(i).getTagId());
            }else {
                sb.append(tags.get(i).getTagId()+",");
            }
        }
        return sb.toString();
    }

}
