package cn.zpeace.blog.controller.admin;



import cn.zpeace.blog.pojo.Category;
import cn.zpeace.blog.service.CategoryService;
import cn.zpeace.blog.util.MyBlogUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    private final Integer pageSize = 5;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/category")
    public String toCategoryPage(Model model, @RequestParam(required = false,defaultValue = "1") Integer pageNum){

        IPage<Category> categoryIPage = categoryService.getAll(pageNum, pageSize);

        model.addAttribute("categories",categoryIPage);

        return "admin/category";
    }

    @ResponseBody
    @PostMapping("/category")
    public String savaCategory(@RequestBody String categoryName){

        Integer statusCode = categoryService.savaOne(new Category(categoryName));

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @PutMapping("/category/{categoryId}")
    public String editCategory(@RequestBody String categoryName,@PathVariable Integer categoryId){
        Integer statusCode = categoryService.updateOne(new Category(categoryId, categoryName,new Date()));

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @DeleteMapping("/category/{categoryId}")
    public String delCategory(@PathVariable Integer categoryId){

        Integer statusCode = categoryService.removeOne(categoryId);

        return MyBlogUtil.getStatusCode(statusCode);

    }


}
