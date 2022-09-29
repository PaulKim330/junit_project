package com.example.junitproject.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //DB와 관련된 컴포넌트들만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired // DI
    private BookRepository bookRepository;

    //@BeforeAll //테스트 시작전에 한번만 실행
    @BeforeEach // 테스트 시작전에 한번씩 실행
    public void 데이터준비(){
        String title = "junit";
        String author = "겟인데어";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();
        bookRepository.save(book);
    }


    //1. 책 등록 Create
    @Test
    @Order(1)
    public void 책등록_test(){
        //given(데이터 준비)
        String title = "junit5";
        String author = "메타코딩";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();
        //stub
        //when(테스트 실행)
        Book bookPS = bookRepository.save(book);

        //then(검증:AssertEquals(기댓값, 실제값))
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }//트랜잭션 종료(저장된 데이터를 초기화함)
    //2. 책 목록보기 Read
    @Test
    public void 책목록보기_test(){
        //given
        String title = "junit";
        String author = "겟인데어";

        //when
        List<Book> bookPS = bookRepository.findAll();

        //then
        assertEquals(title, bookPS.get(0).getTitle());
        assertEquals(author, bookPS.get(0).getAuthor());
    }//트랜잭션 종료(저장된 데이터를 초기화함)

    //3. 책 한건보기 Read-1
    @Test
    @Sql("classpath:db/tableInit.sql")
    public void 책한권보기_test(){
        //given
        String title = "junit";
        String author = "겟인데어";


        //when
        Book bookPS = bookRepository.findById(1L).get();
        // then
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    //4. 책 수정 Update
    @Test
    public void 책수정_test(){
        //given
        Long id = 1L;
        String title = "junit5";
        String author = "메타코딩";
        Book book = new Book(id, title, author);
        //when
        Book bookPS = bookRepository.save(book);

//        bookRepository.findAll().stream()
//                .forEach((b) -> {
//                    System.out.println(b.getId());
//                    System.out.println(b.getTitle());
//                    System.out.println(b.getAuthor());
//                    System.out.println("================================================================");
//                });
        //then
        assertEquals(id, bookPS.getId());
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }

    //5. 책 삭제 Delete
    @Test
    @Sql("classpath:db/tableInit.sql")
    public void 책삭제_test() {
        //given
        Long id = 1L;

        //when
        bookRepository.deleteById(id);

        //then
        assertFalse(bookRepository.findById(id).isPresent());
    }
}
