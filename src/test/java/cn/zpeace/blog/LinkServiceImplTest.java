/*
package cn.zpeace.blog;

import cn.zpeace.blog.pojo.Link;
import cn.zpeace.blog.service.LinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkServiceImplTest {

    @Autowired
    LinkService linkService;

    @Test
    public void saveOne() {
        Link link = new Link();
        for (int i = 0; i < 10; i++) {
            link.setLinkName("友链" + i);
            link.setLinkUrl("www.baidu.com" + i);
            linkService.saveOne(link);
        }
    }

    @Test
    public void updateOne() {
        Link link = new Link("你是猪","www.bibi.com");
        link.setLinkId(1);
        linkService.updateOne(link);
    }

    @Test
    public void removeOne() {
        linkService.removeOne(1);
    }

    @Test
    public void getAll() {
        List<Link> all = linkService.getAll();
        System.out.println(all);
    }

    @Test
    public void getAll1() {
        IPage<Link> all = linkService.getAll(1, 5);
        System.out.println(all.getRecords());
    }
}*/
