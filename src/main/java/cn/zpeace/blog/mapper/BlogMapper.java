package cn.zpeace.blog.mapper;

import cn.zpeace.blog.pojo.Blog;
import cn.zpeace.blog.pojo.MyPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    Integer insertAssociation(Blog blog);

    @Delete("delete from t_blog_tag where blog_id = #{blogId}")
    Integer deleteAssociationById(Integer blogId);

    @Select("SELECT distinct YEAR(create_time) FROM t_blog")
    List<String> getYear();

    @Select("select blog_id,blog_title,create_time from t_blog WHERE YEAR(create_time) = #{year} and published = TRUE")
    List<Blog> getBlogByYear(String year);

    @Select("select blog_id from t_blog_tag where tag_id = #{tagId}")
    List<Integer> getBlogByAssociationTagId(Integer tagId);

    Blog getOne(@Param("blogId") Integer blogId);

    @Update("update t_blog set blog_view = #{blogView} where blog_id = #{blogId}")
    Integer updateView(Integer blogId,Integer blogView);

    List<Blog> getBlogDetail(@Param("page") MyPage page, @Param("keyword")String keyword,
                             @Param("categoryId")Integer categoryId, @Param("published")Boolean published);

    Integer count(@Param("keyword")String keyword, @Param("categoryId")Integer categoryId, @Param("published")Boolean published);

}
