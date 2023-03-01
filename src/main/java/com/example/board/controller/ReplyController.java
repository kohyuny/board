package com.example.board.controller;

import com.example.board.DTO.ReplyDTO;
import com.example.board.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @PostMapping("/reply/register")
    String insert(ReplyDTO replyDTO){
        replyService.insert(replyDTO);
        return "redirect:/detail/"+replyDTO.getId();
    }
    @PostMapping("/reply/delete")
    String delete(ReplyDTO replyDTO){
        replyService.delete(replyDTO);
        return "redirect:/detail/"+replyDTO.getId();
    }
}
