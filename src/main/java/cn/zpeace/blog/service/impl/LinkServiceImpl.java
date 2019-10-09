package cn.zpeace.blog.service.impl;

import cn.zpeace.blog.mapper.LinkMapper;
import cn.zpeace.blog.pojo.Link;
import cn.zpeace.blog.service.LinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkMapper linkMapper;

    @Override
    public Integer saveOne(Link link) {
        return linkMapper.insert(link);
    }

    @Override
    public Integer updateOne(Link link) {
        return linkMapper.updateById(link);
    }

    @Override
    public Integer removeOne(Integer linkId) {
        return linkMapper.deleteById(linkId);
    }

    @Override
    public IPage<Link> getAll(Integer pageNum, Integer pageSize) {
        return linkMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Link>().orderByDesc("create_time"));
    }

    @Override
    public List<Link> getAll() {
        return linkMapper.selectList(null);
    }


}
