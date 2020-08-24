package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@NoArgsConstructor
public class ExecutiveState {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String ExecutiveState;


    @Builder
    public ExecutiveState(Long no, String ExecutiveState) {
        this.no = no;
        this.ExecutiveState = ExecutiveState;
    }


}
