package org.geeksforgeeks.jdbl86.repository;

import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.impl.BookIssueRepository;
import org.geeksforgeeks.jdbl86.repository.jpa.BookIssueJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class BookRepositoryTest {

    @Mock
    private BookIssueJPARepository bookIssueJPARepository;

    @InjectMocks
    private BookIssueRepository bookIssueRepository;

    static long id = 1L;

    @Test
    void getById_when_bookIssue_is_found() {
        BookIssueEntity bookIssueEntity = BookIssueEntity.builder()
                .id(id)
                .build();

        Mockito.when(bookIssueJPARepository.findById(id))
                .thenReturn(Optional.of(bookIssueEntity));

        BookIssueEntity foundObj = this.bookIssueRepository.getById(id);

        Assertions.assertEquals(bookIssueEntity, foundObj);
    }

    @Test
    void getById_when_bookIssue_is_not_found() {
        Mockito.when(bookIssueJPARepository.findById(id))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> bookIssueRepository.getById(id));
    }
}
