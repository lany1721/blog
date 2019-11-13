/*
package cn.zpeace.blog;

import cn.zpeace.blog.mapper.BlogMapper;
import cn.zpeace.blog.pojo.Blog;
import cn.zpeace.blog.pojo.MyPage;
import cn.zpeace.blog.service.BlogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogService blogService;

    @Test
    public void savaOne() {
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        Blog blog = new Blog();
//        blog.setBlogId(2);
//        blog.setBlogTitle("123");
//        blog.setBlogContent("123456789");
//        blog.setTagIds(ids);
//        blogMapper.insertAssociation(blog);
    }

    @Test
    public void updateOne() {
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(5);
//        ids.add(7);
//        Blog blog = new Blog();
//        blog.setBlogId(12);
//        blog.setBlogTitle("123");
//        blog.setBlogContent("123456789");
//        blog.setTagIds(ids);
//        blogService.updateOne(blog);
    }

    @Test
    public void removeOne() {
    }

    @Test
    public void getOne() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findByKeyword() {
        blogService.findByKeyword(1,5,2,"博客");
    }

    @Test
    public void countByCategory() {
        Integer integer = blogService.countByCategory(2);
        System.out.println(integer);
    }

    @Test
    public void getByTag() {
        IPage<Blog> byTag = blogService.getByTag(1, 5, 1);
    }



    @Test
    public void getAlldetail1() {
        MyPage<Blog> page = new MyPage<>(1,5);
        List<Blog> test = blogMapper.getBlogDetail(page,"测试");
        Integer counttest = blogMapper.count("测试");
        System.out.println(counttest);
        page.setRecords(test);
        System.out.println(test);
    }
}*/
