package cn.zpeace.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("t_link")
public class Link {

    @TableId(type = IdType.AUTO)
    private Integer linkId;

    private String linkName;

    private String linkUrl;

    private Date createTime;

    private Date updateTime;

    public Link(String linkName, String linkUrl) {
        this.linkName = linkName;
        this.linkUrl = linkUrl;
    }
}
