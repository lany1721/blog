package cn.zpeace.blog.controller.admin;


import cn.zpeace.blog.pojo.Blog;
import cn.zpeace.blog.service.BlogService;
import cn.zpeace.blog.service.CategoryService;
import cn.zpeace.blog.service.TagService;
import cn.zpeace.blog.util.MyBlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String EDITOR = "admin/editor";
    private static final String BLOGS = "admin/blog";
    private static final String REDIRECT_BLOGS= "redirect:/admin/blog";
    private static final Integer pageSize = 5;

    @Value("${fileSever}")
    private String fileSever;

    @Value("${parentDirPath}")
    private String parentDirPath;

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @GetMapping("/blog")
    public String blogManeger(@RequestParam(defaultValue = "1",required = false) Integer pageNum,Model model,
                              @RequestParam(required = false)Integer categoryId,
                              @RequestParam(required = false)String keyword){



        model.addAttribute("blogs",blogService.getAll(pageNum,pageSize,keyword,categoryId,false));

        model.addAttribute("categories",categoryService.getAll());

        model.addAttribute("categoryId",categoryId);

        model.addAttribute("keyword",keyword);

        return BLOGS;
    }

    @GetMapping("/editor")
    public String toEditor(Model model){

        setTypeAndTag(model);

        model.addAttribute("blog", new Blog());

        return EDITOR;
    }

    @GetMapping("/blog/{blogId}")
    public String toEditBlog(@PathVariable Integer blogId,Model model){

        setTypeAndTag(model);


        Blog blog = blogService.getOne(blogId);


        model.addAttribute("blog",blog);

        return EDITOR;
    }

    @PostMapping("/blog")
    public String saveBlog(Blog blog){


        blogService.savaOne(blog);

        return REDIRECT_BLOGS;
    }

    @ResponseBody
    @PostMapping("/blog/md/uploadimg")
    public Map<String,Object> mdUpload(@RequestParam(value = "editormd-image-file",required = false) MultipartFile file,
                                       HttpServletRequest request,
                                       HttpServletResponse response){

        Map<String,Object> result = new HashMap<String, Object>();


        String fileName = file.getOriginalFilename();//文件名
        String newFileName = MyBlogUtil.getNewFileName(fileName);

        //用户文件存储的路径
        String userPath = MyBlogUtil.getUserDirectory(request.getSession());


        //博客图片保存目录
        String blogPath = parentDirPath + userPath + "blog" + File.separator + "img";

        //获得最终保存的目录
        File blogDir = new File(blogPath);
        if (!blogDir.exists()){
            blogDir.mkdirs();
        }

        //最终文件上传的路径
        File filePath = new File(blogPath + File.separator + newFileName);

        String fileUrl = fileSever + userPath.replace("\\","/") + "blog/img/" + newFileName;

        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            file.transferTo(filePath);

            result.put("success",1);
            result.put("message","上传成功");
            result.put("url",fileUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            result.put("success",0);
            e.printStackTrace();

        }


        return result;
    }

    @PutMapping("/blog")
    public String editBlog(Blog blog){

        if (blog.getPublished() == null){
            blog.setPublished(false);
        }
        if (blog.getAppreciation() == null){
            blog.setAppreciation(false);
        }
        if (blog.getComment() == null){
            blog.setComment(false);
        }
        if (blog.getCopyright() == null) {
            blog.setCopyright(false);
        }
        blogService.updateOne(blog);

        return REDIRECT_BLOGS;
    }


    @ResponseBody
    @DeleteMapping("/blog/{blogId}")
    public String delBlog(@PathVariable Integer blogId){

        Integer statusCode = blogService.removeOne(blogId);

        return MyBlogUtil.getStatusCode(statusCode);
    }


    private void setTypeAndTag(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("tags", tagService.getAll());
    }

}
