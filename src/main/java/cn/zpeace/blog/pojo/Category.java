package cn.zpeace.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@TableName("t_category")
@Data
@NoArgsConstructor
public class Category {

    public Category(Integer categoryId, String categoryName,Date updateTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.updateTime = updateTime;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    private String categoryName;

    private Date createTime;

    private Date updateTime;

    @TableField(exist = false)
    private List<Blog> blogs;
}
