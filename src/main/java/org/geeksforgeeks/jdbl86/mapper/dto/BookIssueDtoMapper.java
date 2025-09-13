package org.geeksforgeeks.jdbl86.mapper.dto;

import org.geeksforgeeks.jdbl86.dto.BookIssueDto;
import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.repository.impl.BookRepository;
import org.geeksforgeeks.jdbl86.repository.impl.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookIssueDtoMapper {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookIssueDtoMapper(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookIssueEntity toEntity(BookIssueDto bookIssueDto) {
        UserEntity userEntity = this.userRepository.getUserById(bookIssueDto.getUserId());
        BookEntity bookEntity = this.bookRepository.getBookById(bookIssueDto.getBookId());
        LocalDate expiryDate = bookIssueDto.getIssueDate().plusDays(14);
        return BookIssueEntity.builder()
                .userEntity(userEntity)
                .bookEntity(bookEntity)
                .issueDate(bookIssueDto.getIssueDate())
                .expiryDate(expiryDate)
                .build();
    }
}
