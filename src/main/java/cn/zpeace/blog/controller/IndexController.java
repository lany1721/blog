package cn.zpeace.blog.controller;

import cn.zpeace.blog.exception.NotFoundException;
import cn.zpeace.blog.pojo.*;
import cn.zpeace.blog.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final Integer pageSize = 5;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;

    @Autowired
    LinkService linkService;

    @Autowired
    UserService userService;

    @GetMapping({"/","/index","/index.html"})
    public String index(Model model,@RequestParam(defaultValue = "1",required = false) Integer pageNum,
                        @RequestParam(required = false) String keyword){

        MyPage<Blog> blogPage = blogService.getAll(pageNum,pageSize,null,null,true);

        sidebar(model);

        model.addAttribute("blogs",blogPage);

        return "index";
    }

    @GetMapping("/search/{keyword}")
    public String search(Model model,@RequestParam(defaultValue = "1",required = false) Integer pageNum,
                         @PathVariable String keyword){

        MyPage<Blog> blogPage = blogService.getAll(pageNum, pageSize,keyword,null,true);

        sidebar(model);

        model.addAttribute("blogs",blogPage);
        model.addAttribute("keyword",keyword);

        return "index";
    }

    @GetMapping("/archives")
    public String archives(Model model){

        sidebar(model);
        Map<String, List<Blog>> archives = blogService.getArchives();

        model.addAttribute("archives",archives);

        return "archives";
    }

    @GetMapping("/categories")
    public String categories(Model model){

        sidebar(model);
        model.addAttribute("categories",categoryService.getUsed());

        return "categories";
    }

    @GetMapping("/category/{categoryId}")
    public String category(@PathVariable Integer categoryId,
                           @RequestParam(defaultValue = "1" ,required = false) Integer pageNum,
                           Model model){

        sidebar(model);

        Category category = categoryService.getOne(categoryId);

        if (category == null) {
            throw new NotFoundException("访问的资源不存在");
        }else {
            MyPage<Blog> blogBycategory = blogService.getAll(pageNum, pageSize, null, categoryId,true);
            model.addAttribute("blogs",blogBycategory);
        }

        model.addAttribute("category",category);




        return "categoryitem";

    }

    @GetMapping("/tags")
    public String tags(Model model){

        sidebar(model);
        model.addAttribute("tags",tagService.getAll());


        return "tags";
    }

    @GetMapping("/tag/{tagId}")
    public String tag(Model model,@PathVariable Integer tagId,
                      @RequestParam(defaultValue = "1",required = false)Integer pageNum){

        Tag tag = tagService.getOne(tagId);


        if (tag == null){
            throw new NotFoundException("访问的资源不存在");
        }
        IPage<Blog> byTag = blogService.getByTag(pageNum, pageSize, tagId);

        sidebar(model);
        model.addAttribute("tag",tag);
        model.addAttribute("blogs",byTag);

        return "tagitem";
    }



    @GetMapping("/article/{articleId}")
    public String article(@PathVariable Integer articleId, Model model, HttpSession session){


        Blog blog = blogService.getOneAndConvert(articleId);

        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }else {
            Object blogVisit = session.getAttribute("blogVisit" + articleId);
            session.setMaxInactiveInterval(60*60*24);  //设置一天后过期
            if (blogVisit == null){
                blogService.updateView(articleId,blog.getBlogView()+1);
                session.setAttribute("blogVisit"+articleId,"yes");
            }


            model.addAttribute("blog",blog);
        }
        sidebar(model);


        return "article";
    }

    @GetMapping("/about")
    public String about(Model model){


        String aboutMe = userService.getIntroduceAndConvert(5);


        model.addAttribute("about",aboutMe);

        sidebar(model);

        return "about";
    }



    private void sidebar(Model model){

        model.addAttribute("links",linkService.getAll());
        model.addAttribute("countCategory",categoryService.count());
        model.addAttribute("countBlog",blogService.count());
        model.addAttribute("countTag",tagService.count());
    }
}
