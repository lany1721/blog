package cn.zpeace.blog.service;

import cn.zpeace.blog.pojo.Link;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface LinkService {

    Integer saveOne(Link link);

    Integer updateOne(Link link);

    Integer removeOne(Integer linkId);

    IPage<Link> getAll(Integer pageNum, Integer pageSize);

    List<Link> getAll();

}
