package cn.zpeace.blog.mapper;

import cn.zpeace.blog.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> getAll();
}
