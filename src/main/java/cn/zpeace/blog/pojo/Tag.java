package cn.zpeace.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_tag")
@Data
@NoArgsConstructor
public class Tag {

    @TableId(type = IdType.AUTO)
    private Integer tagId;

    private String tagName;

    private Date createTime;

    private Date updateTime;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }
}
