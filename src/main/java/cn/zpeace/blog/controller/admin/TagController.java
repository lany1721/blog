package cn.zpeace.blog.controller.admin;


import cn.zpeace.blog.pojo.Tag;
import cn.zpeace.blog.service.TagService;
import cn.zpeace.blog.util.MyBlogUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TagController {

    private final Integer pageSize = 5;

    @Autowired
    TagService tagService;

    @GetMapping("/tag")
    public String toTagPage(Model model, @RequestParam(defaultValue = "1",required = false)Integer pageNum){

        IPage<Tag> tags = tagService.getAll(pageNum, pageSize);

        model.addAttribute("tags",tags);

        return "admin/tag";
    }

    @ResponseBody
    @PostMapping("/tag")
    public String saveTag(@RequestBody String tagName){
        Integer statusCode = tagService.saveOne(new Tag(tagName));

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @PutMapping("/tag/{tagId}")
    public String editTag(@RequestBody String tagName,@PathVariable Integer tagId) {
        Integer statusCode = tagService.update(new Tag(tagId, tagName));

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @DeleteMapping("/tag/{tagId}")
    public String delTag(@PathVariable Integer tagId){

        Integer statusCode = tagService.removeOne(tagId);

        return MyBlogUtil.getStatusCode(statusCode);
    }

}
