package com.example.board.controller;

import com.example.board.DTO.ArticleDTO;
import com.example.board.entity.Article;
import org.springframework.ui.Model;

import java.util.List;

public interface ArticleController {
    String selectAll(Model model);
    String selectOne(int id, Model model);
    String insert(ArticleDTO articleDTO);
    String update(ArticleDTO articleDTO);
    String delete(int id);
}
