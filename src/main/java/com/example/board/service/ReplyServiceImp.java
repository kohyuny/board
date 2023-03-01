package com.example.board.service;

import com.example.board.DTO.ReplyDTO;
import com.example.board.entity.Reply;
import com.example.board.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReplyServiceImp implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<ReplyDTO> selectAll() {
        List<Reply> list = replyMapper.selectAll();
        list.forEach(reply -> String.valueOf(list));
        List<ReplyDTO> list1 = list.stream()
                .map(reply -> modelMapper.map(reply,ReplyDTO.class))
                .collect(Collectors.toList());
        list1.forEach(replyDTO -> String.valueOf(replyDTO));
        return list1;
    }

    @Override
    public int insert(ReplyDTO replyDTO) {
        int result =replyMapper.insert(modelMapper.map(replyDTO, Reply.class));

        return result<0 ? 0 : 1;
    }

    @Override
    public int delete(ReplyDTO replyDTO) {
        int result = replyMapper.delete(modelMapper.map(replyDTO, Reply.class));
        return result<0? 0 : 1;
    }
}
