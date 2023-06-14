package com.example.hogwarts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private int age;

}
