package com.example.demo.model;

import lombok.Getter;

@Getter
public class BookResponseDto {


    private Long id;
    private String title;
    private String content;

    public BookResponseDto(Book entity){
        this.id = entity.getDataNo();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
