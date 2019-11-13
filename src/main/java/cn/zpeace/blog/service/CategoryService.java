package cn.zpeace.blog.service;


import cn.zpeace.blog.pojo.Category;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;


public interface CategoryService {

    Integer savaOne(Category category);

    Integer updateOne(Category category);

    Integer removeOne(Integer categoryId);

    Category getOne(Integer categoryId);

    IPage<Category> getAll(Integer pageNum, Integer pageSize);

    List<Category>  getAll();

    List<Category>  getUsed();

    Integer count();
}
