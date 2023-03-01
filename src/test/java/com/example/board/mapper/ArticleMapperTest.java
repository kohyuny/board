package com.example.board.mapper;

import com.example.board.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ArticleMapperTest {
    @Autowired
    ArticleMapper mapper;
    @Test
    void insert() {
        Article article = Article.builder()
                .title("title1")
                .content("body1")
                .build();
        mapper.insert(article);
    }

    @Test
    void update() {
        Article article = Article.builder()
                .title("수정")
                .id(2)
                .build();
        mapper.update(article);
    }

    @Test
    void delete() {
        Article article = Article.builder()
                .id(2)
                .build();
        mapper.delete(article);
    }

    @Test
    void selectAll() {
        List<Article> list = mapper.selectAll();
        list.forEach(article -> log.info(String.valueOf(article)));
        for (Article article: list) {
            log.info(String.valueOf(article));
        }

    }

    @Test
    void selectOne() {
        Article article = Article.builder()
                .id(3)
                .build();
        log.info(mapper.selectOne(article).toString());
        log.info(String.valueOf(mapper.selectOne(article)));
    }
}