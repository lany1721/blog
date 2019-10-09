package cn.zpeace.blog.controller.admin;


import cn.zpeace.blog.pojo.Link;
import cn.zpeace.blog.service.LinkService;
import cn.zpeace.blog.util.MyBlogUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class LinkController {

    private final Integer pageSize = 5;

    @Autowired
    LinkService linkService;

    @GetMapping("/link")
    public String toLinkPage(@RequestParam(defaultValue = "1",required = false)Integer pageNum, Model model){

        IPage<Link> linkIPage = linkService.getAll(pageNum, pageSize);

        model.addAttribute("links",linkIPage);

        return "admin/link";
    }

    @ResponseBody
    @PostMapping("/link")
    public String savaLink(@RequestBody Link link){

        Integer statusCode = linkService.saveOne(link);

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @PutMapping("/link/{linkId}")
    public String editLink(@PathVariable Integer linkId,@RequestBody Link link){


        Integer statusCode = linkService.updateOne(link);

        return MyBlogUtil.getStatusCode(statusCode);
    }

    @ResponseBody
    @DeleteMapping("/link/{linkId}")
    public String delLink(@PathVariable Integer linkId){

        Integer statusCode = linkService.removeOne(linkId);

        return MyBlogUtil.getStatusCode(statusCode);
    }
}
