package cn.zpeace.blog.service;


import cn.zpeace.blog.pojo.Blog;
import cn.zpeace.blog.pojo.MyPage;
import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;
import java.util.Map;


public interface BlogService {

    Integer savaOne(Blog blog);

    Integer updateOne(Blog blog);

    Integer removeOne(Integer blogId);

    Blog getOne(Integer blogId);

    Blog getOneAndConvert(Integer blogId);

    Integer updateView(Integer blogId,Integer blogView);

    Map<String, List<Blog>> getArchives();

    Integer countBlog();

    IPage<Blog> getByTag(Integer pageNum,Integer pageSize,Integer tagId);

    MyPage<Blog> getAlldetail(Integer pageNum, Integer pageSize, String keyword ,Integer categoryId ,Boolean published);

}
