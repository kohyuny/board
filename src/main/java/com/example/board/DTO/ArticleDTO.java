package com.example.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {
    private int id;
    private String title;
    private String content;
    private String userid;
    private LocalDate regdate;
    private LocalDate moddate;
    private int cnt;

}
