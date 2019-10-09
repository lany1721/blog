package cn.zpeace.blog.service;


import cn.zpeace.blog.pojo.Category;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;


public interface CategoryService {

    Integer savaOne(Category category);

    Integer update(Category category);

    Integer removeOne(Integer categoryId);

    Category getOneByName(String categoryName);

    Category getOneById(Integer categoryId);

    IPage<Category> getAll(Integer pageNum, Integer pageSize);

    List<Category>  getAll();

    Integer count();
}
