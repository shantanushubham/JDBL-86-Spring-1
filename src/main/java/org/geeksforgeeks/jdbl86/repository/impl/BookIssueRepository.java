package org.geeksforgeeks.jdbl86.repository.impl;

import org.geeksforgeeks.jdbl86.db_response.BookIssueCount;
import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.jpa.BookIssueJPARepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BookIssueRepository {

    private final BookIssueJPARepository bookIssueJPARepository;

    public BookIssueRepository(BookIssueJPARepository bookIssueJPARepository) {
        this.bookIssueJPARepository = bookIssueJPARepository;
    }

    public BookIssueEntity addBookIssue(BookIssueEntity bookIssueEntity) {
        return this.bookIssueJPARepository.save(bookIssueEntity);
    }

    public List<BookIssueEntity> getAll() {
        return this.bookIssueJPARepository.findAll();
    }

    public BookIssueEntity getById(long id) {
        return this.bookIssueJPARepository.findById(id).orElseThrow(
                () -> new NotFoundException(BookIssueEntity.class, "id", id)
        );
    }

    public List<BookIssueCount> getTopNIssuedBooks(int n) {
        Pageable topN = PageRequest.of(0, n);
        return this.bookIssueJPARepository.findMostIssuedBooks(topN);
    }

    public void deleteById(long id) {
        this.bookIssueJPARepository.deleteById(id);
    }

    public List<BookEntity> getAllActiveBooksIssuedByUser(long userId) {
        LocalDate currentDate = LocalDate.now();
        return this.bookIssueJPARepository
                .findByUserEntity_IdAndExpiryDateGreaterThanEqual(userId, currentDate)
                .stream()
                .map(BookIssueEntity::getBookEntity)
                .toList(); // Java 17 and above
    }
}
