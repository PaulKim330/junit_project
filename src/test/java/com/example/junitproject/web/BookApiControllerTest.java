package com.example.junitproject.web;

import com.example.junitproject.domain.Book;

public class BookApiControllerTest {
    public void test(){
        Book book = Book.builder()
                .id(1L)
                .title("안녕")
                .author("안녕")
                .build();
    }
}
