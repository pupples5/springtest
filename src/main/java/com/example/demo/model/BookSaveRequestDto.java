package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {


    private String title;
    private String content;


    @Builder
    public BookSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .content(content)
                .build();
    }


}
