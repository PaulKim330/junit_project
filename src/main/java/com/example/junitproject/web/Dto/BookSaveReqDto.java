package com.example.junitproject.web.Dto;

import com.example.junitproject.domain.Book;
import lombok.Setter;

@Setter //Controller 에서 Setter가 호출되면서 Dto에 값이 채워짐.
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity(){
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }
}
