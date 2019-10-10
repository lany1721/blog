package cn.zpeace.blog.service;

import cn.zpeace.blog.pojo.Tag;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface TagService {

    Integer saveOne(Tag tag);

    Integer update(Tag tag);

    Integer removeOne(Integer tagId);

    Tag getOne(Integer tagId);

    IPage<Tag> getAll(Integer pageNum,Integer pageSize);

    List<Tag> getAll();

    Integer count();

}
