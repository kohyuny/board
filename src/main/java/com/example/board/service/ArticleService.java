package com.example.board.service;

import com.example.board.DTO.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> selectAll();
    ArticleDTO selectOne(ArticleDTO articleDTO);
    int insert(ArticleDTO articleDTO);
    int update(ArticleDTO articleDTO);
    int delete(ArticleDTO articleDTO);

}
