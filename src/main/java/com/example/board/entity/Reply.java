package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
    private int rid;
    private int id;
    private String userid;
    private String content;
    private LocalDate regdate;


}
