package cn.zpeace.blog.service.impl;

import cn.zpeace.blog.mapper.TagMapper;
import cn.zpeace.blog.pojo.Tag;
import cn.zpeace.blog.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;


    @Override
    public Integer saveOne(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public Integer update(Tag tag) {
        return tagMapper.updateById(tag);
    }

    @Override
    public Integer removeOne(Integer tagId) {
        tagMapper.deleteAssociationById(tagId);
        return tagMapper.deleteById(tagId);
    }

    @Override
    public Tag getOne(Integer tagId) {
        return tagMapper.selectById(tagId);
    }

    @Override
    public IPage<Tag> getAll(Integer pageNum, Integer pageSize) {
        return tagMapper.selectPage(new Page<Tag>(pageNum,pageSize),new QueryWrapper<Tag>().orderByDesc("create_time"));
    }

    @Override
    public List<Tag> getAll() {
        return tagMapper.selectList(null);
    }

    @Override
    public Integer count() {
        return tagMapper.selectCount(null);
    }
}
