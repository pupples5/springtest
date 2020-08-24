package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateRequestDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BookUpdateRequestDto(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;

    }


}
