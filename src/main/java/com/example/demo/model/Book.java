package com.example.demo.model;

import lombok.*;


import javax.persistence.*;

@Getter
@Entity

@Table(name ="book")
@Setter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dataNo;
    private @Column(name = "title") String title;
    private @Column(name = "content") String content;

    @Builder
    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
