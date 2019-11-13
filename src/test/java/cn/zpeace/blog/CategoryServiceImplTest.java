/*
package cn.zpeace.blog;

import cn.zpeace.blog.pojo.Category;
import cn.zpeace.blog.service.CategoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @Test
    public void savaOne() {
        Category category = new Category();

        category.setCreateTime(new Date());
        for (int i = 0; i < 10; i++) {
            category.setCategoryName("Categoty"+i);
            categoryService.savaOne(category);
        }

    }

    @Test
    public void updateOne() {
        Category category = new Category();
        category.setCategoryId(4);
        category.setCategoryName("你是猪...");
        category.setUpdateTime(new Date());
        categoryService.updateOne(category);
    }

    @Test
    public void removeOne() {
        categoryService.removeOne(3);
    }

    @Test
    public void getOneByName() {
        Category category = categoryService.getOneByName("你是猪");
        System.out.println(category);
    }

    @Test
    public void getOne() {
        Category category = categoryService.getOne(9);
        System.out.println(category);
    }

    @Test
    public void listAll() {
        IPage<Category> iPage = categoryService.getAll(2,5);


    }

    @Test
    public void count() {
        Integer count = categoryService.count();
        System.out.println(count);
    }
}*/
