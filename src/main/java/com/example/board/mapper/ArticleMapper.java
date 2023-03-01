package com.example.board.mapper;

import com.example.board.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article (title, content, userid, regdate, cnt) values(#{article.title},#{article.content},#{article.userid},#{article.regdate},#{article.cnt})")
    int insert(@Param("article")Article article);
    @Update("update article set title = #{article.title}, content = #{article.content}, moddate = #{article.moddate}, cnt = #{article.cnt} where id = #{article.id}")
    int update(@Param("article")Article article);
    @Delete("delete from article where id = #{article.id}")
    int delete(@Param("article")Article article);

    @Select("select * from article")
    List<Article> selectAll();

    @Select("select * from article where id = #{article.id}")
    Article selectOne(@Param("article") Article article);
}
