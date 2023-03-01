package com.example.board.service;

import com.example.board.DTO.ArticleDTO;
import com.example.board.entity.Article;
import com.example.board.mapper.ArticleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleSerivceImp implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<ArticleDTO> selectAll() {
        List<Article> list = articleMapper.selectAll();
        list.forEach(article -> String.valueOf(article));
        List<ArticleDTO> list1 = list.stream()
                .map(article->modelMapper.map(article,ArticleDTO.class))
                .collect(Collectors.toList());
        list1.forEach(articleDTO -> String.valueOf(articleDTO));

        return list1;
    }

    @Override
    public ArticleDTO selectOne(ArticleDTO articleDTO) {

        Article article = articleMapper.selectOne(modelMapper.map(articleDTO, Article.class));
        article.setCnt(article.getCnt()+1);
        articleMapper.update(article);
        return modelMapper.map(article,ArticleDTO.class);
    }

    @Override
    public int insert(ArticleDTO articleDTO) {
        articleDTO.setRegdate(LocalDate.now());
        int result = articleMapper.insert(modelMapper.map(articleDTO, Article.class));
        if(result<0){
            return 0;
        }
        return 1;
    }

    @Override
    public int update(ArticleDTO articleDTO) {
        articleDTO.setModdate(LocalDate.now());
        int result = articleMapper.update(modelMapper.map(articleDTO, Article.class));
        if (result<0){
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(ArticleDTO articleDTO) {
        int result = articleMapper.delete(modelMapper.map(articleDTO, Article.class));
        if(result<0){
            return 0;
        }
        return 1;
    }
}
