package cn.zpeace.blog.service.impl;

import cn.zpeace.blog.mapper.CategoryMapper;
import cn.zpeace.blog.pojo.Category;
import cn.zpeace.blog.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Integer savaOne(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Integer updateOne(Category category) {
        return categoryMapper.updateById(category);
    }

    @Override
    public Integer removeOne(Integer categoryId) {


        return  categoryMapper.deleteById(categoryId);
    }

    @Override
    public Category getOne(Integer categoryId) {
        return categoryMapper.selectById(categoryId);
    }

    @Override
    public IPage<Category> getAll(Integer pageNum, Integer pageSize) {

        return categoryMapper.selectPage(new Page<Category>(pageNum,pageSize),new QueryWrapper<Category>().orderByDesc("create_time"));
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.selectList(new QueryWrapper<Category>().select("category_id","category_name"));
    }

    @Override
    public List<Category> getUsed() {
        return categoryMapper.getAll();
    }

    @Override
    public Integer count() {
        return categoryMapper.selectCount(null);
    }


}
