package com.example.board.service;

import com.example.board.DTO.ReplyDTO;

import java.util.List;

public interface ReplyService {
    List<ReplyDTO> selectAll();

    int insert(ReplyDTO replyDTO);

    int delete(ReplyDTO replyDTO);
}
