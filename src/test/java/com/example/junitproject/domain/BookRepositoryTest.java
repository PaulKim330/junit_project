package com.example.junitproject.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest //DB와 관련된 컴포넌트들만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired // DI
    private BookRepository bookRepository;


    //1. 책 등록 Create
    @Test
    public void 책등록_test(){
        System.out.println("책등록_test 실행");
    }
    //2. 책 목록보기 Read

    //3. 책 한건보기 Read-1

    //4. 책 수정 Update

    //5. 책 삭제 Delete
}
