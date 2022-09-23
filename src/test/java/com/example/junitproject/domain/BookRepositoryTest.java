package com.example.junitproject.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //DB와 관련된 컴포넌트들만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired // DI
    private BookRepository bookRepository;


    //1. 책 등록 Create
    @Test
    public void 책등록_test(){
        //given(데이터 준비)
        String title = "junit5";
        String author = "메타코딩";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        //when(테스트 실행)
        Book bookPS = bookRepository.save(book);

        //then(검증)
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }
    //2. 책 목록보기 Read

    //3. 책 한건보기 Read-1

    //4. 책 수정 Update

    //5. 책 삭제 Delete
}
