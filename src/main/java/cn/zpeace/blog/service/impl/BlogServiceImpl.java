package cn.zpeace.blog.service.impl;

import cn.zpeace.blog.exception.NotFoundException;
import cn.zpeace.blog.mapper.BlogMapper;
import cn.zpeace.blog.mapper.TagMapper;
import cn.zpeace.blog.pojo.Blog;
import cn.zpeace.blog.pojo.MyPage;
import cn.zpeace.blog.service.BlogService;
import cn.zpeace.blog.util.MarkdownUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public Integer savaOne(Blog blog) {


        String blogBrief = MarkdownUtil.markdownToHtmlExtensions(blog.getBlogBrief());

        blog.setBlogBrief(blogBrief);

        blogMapper.insert(blog);


        return blogMapper.insertAssociation(blog);
    }

    @Override
    public Integer updateOne(Blog blog) {

        blogMapper.deleteAssociationById(blog.getBlogId());

        blogMapper.insertAssociation(blog);

        blog.setBlogBrief(MarkdownUtil.markdownToHtmlExtensions(blog.getBlogBrief()));

        blog.setUpdateTime(new Date());

        return blogMapper.updateById(blog);
    }

    @Override
    public Integer removeOne(Integer blogId) {
        blogMapper.deleteAssociationById(blogId);
        return blogMapper.deleteById(blogId);
    }

    @Override
    public Blog getOne(Integer blogId) {

        Blog blog = blogMapper.getOne(blogId);


        return blog;
    }

    @Override
    public Blog getOneAndConvert(Integer blogId) {
        Blog blog = blogMapper.getOne(blogId);
        if (blog == null) {
            throw new NotFoundException("该博文不存在");
        }
        blog.setBlogContent(MarkdownUtil.markdownToHtmlExtensions(blog.getBlogContent()));
        return blog;
    }

    @Override
    public Integer updateView(Integer blogId,Integer blogView) {
        return blogMapper.updateView(blogId,blogView);
    }


    @Override
    public Map<String, List<Blog>> getArchives() {
        List<String> years = blogMapper.getYear();
        Map<String, List<Blog>> map = new HashMap<>();

        for (String year : years) {
            map.put(year,blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public Integer count() {
        return blogMapper.count(null,null,true);
    }

    @Override
    public IPage<Blog> getByTag(Integer pageNum, Integer pageSize, Integer tagId) {
        List<Integer> blogIds = blogMapper.getBlogByAssociationTagId(tagId);

        if (blogIds == null || blogIds.size() <= 0) {
            return null;
        }

        return blogMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Blog>()
                .orderByDesc("create_time").in("blog_id",blogIds).eq("published",true));
    }

    @Override
    public MyPage<Blog> getAll(Integer pageNum, Integer pageSize, String keyword , Integer categoryId , Boolean published) {


        MyPage<Blog> page = new MyPage<>(pageNum,pageSize,blogMapper.count(keyword,categoryId,published));

        List<Blog> blogs = blogMapper.getBlogDetail(page, keyword,categoryId,published);

        if (blogs == null) {
            throw new NotFoundException("搜索结果不存在");
        }
        page.setRecords(blogs);

        return page;
    }

}
