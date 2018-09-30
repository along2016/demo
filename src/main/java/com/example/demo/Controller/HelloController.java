package com.example.demo.Controller;

import com.example.demo.Vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Book book;

    @RequestMapping(value = "/hello")
    public String hello(){
        return book.getDesc();
    }
}
