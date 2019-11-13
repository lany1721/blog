/*
package cn.zpeace.blog;

import cn.zpeace.blog.pojo.Tag;
import cn.zpeace.blog.service.TagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceImplTest {

    @Autowired
    TagService tagService;

    @Test
    public void saveOne() {
        Tag tag = new Tag();
        for (int i = 0; i < 10; i++) {
            tag.setTagName("李白"+i);
            tagService.saveOne(tag);
        }

    }

    @Test
    public void updateOne() {
        Tag tag = new Tag();
        tag.setTagId(1);
        tag.setTagName("公孙离");
        tagService.updateOne(tag);

    }

    @Test
    public void removeOne() {
        tagService.removeOne(11);
    }

    @Test
    public void getOne() {
        Tag tag = tagService.getOne(1);
        System.out.println(tag);
    }

    @Test
    public void getAll() {
        IPage<Tag> all = tagService.getAll(1, 5);
        System.out.println(all.getRecords());
    }
}*/
