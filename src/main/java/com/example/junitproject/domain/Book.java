package com.example.junitproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 20, nullable = false)
    private String author;

    @Builder
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
