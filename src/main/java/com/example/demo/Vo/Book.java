package com.example.demo.Vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;

    @Value("${book.desc}")
    private String desc;

}
