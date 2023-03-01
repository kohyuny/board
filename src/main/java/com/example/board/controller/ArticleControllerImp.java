package com.example.board.controller;

import com.example.board.DTO.ArticleDTO;
import com.example.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ArticleControllerImp implements ArticleController{
    @Autowired
    ArticleService articleService;

    @Override
    @GetMapping("/list")
    public String selectAll(Model model) {
        model.addAttribute("list", articleService.selectAll());
        return "list";
    }

    @Override
    @GetMapping("/detail/{id}")
    public String selectOne(@PathVariable("id") int id, Model model) {
        ArticleDTO articleDTO=new ArticleDTO();
        articleDTO.setId(id);
        model.addAttribute("articleDTO",articleService.selectOne(articleDTO));

        return "detail";
    }
    @GetMapping("/register")
    public String insert(){
        return "register";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model){
        ArticleDTO articleDTO=new ArticleDTO();
        articleDTO.setId(id);
        model.addAttribute("articleDTO",articleService.selectOne(articleDTO));
        return "edit";
    }
    @Override
    @PostMapping("/register")
    public String insert(ArticleDTO articleDTO) {
        articleService.insert(articleDTO);
        return "redirect:/list";
    }

    @Override
    @PostMapping("/edit")
    public String update(ArticleDTO articleDTO) {

        articleService.update(articleDTO);
        return "redirect:/detail/"+articleDTO.getId();
    }

    @Override
    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        ArticleDTO articleDTO=new ArticleDTO();
        articleDTO.setId(id);
        articleService.delete(articleDTO);
        return "redirect:/list";
    }
}
