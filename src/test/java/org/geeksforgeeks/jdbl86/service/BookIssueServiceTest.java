package org.geeksforgeeks.jdbl86.service;

import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.repository.impl.BookIssueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class BookIssueServiceTest {

    @Mock
    private BookIssueRepository bookIssueRepository;

    @InjectMocks
    private BookIssueService bookIssueService;

    @Test
    void saveBookIssue_when_book_is_issued_successfully() {
        LocalDate now = LocalDate.now();
        LocalDate exp = now.plusDays(14);
        BookIssueEntity bookIssueEntity = BookIssueEntity.builder()
                .id(1L)
                .issueDate(now)
                .expiryDate(exp)
                .userEntity(UserEntity.builder().build())
                .bookEntity(BookEntity.builder().build())
                .build();

        Mockito.when(bookIssueRepository.addBookIssue(bookIssueEntity)).thenReturn(bookIssueEntity);

        BookIssueEntity savedEntity = this.bookIssueService.saveBookIssue(bookIssueEntity);
        Assertions.assertEquals(bookIssueEntity, savedEntity);
    }

}
