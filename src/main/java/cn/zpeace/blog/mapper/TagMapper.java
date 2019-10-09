package cn.zpeace.blog.mapper;

import cn.zpeace.blog.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper extends BaseMapper<Tag> {


    Integer deleteAssociationById(Integer tagId);
}
