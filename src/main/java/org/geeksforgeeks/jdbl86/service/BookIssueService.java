package org.geeksforgeeks.jdbl86.service;

import org.geeksforgeeks.jdbl86.db_response.BookIssueCount;
import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.geeksforgeeks.jdbl86.repository.impl.BookIssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueService {

    private final BookIssueRepository bookIssueRepository;

    public BookIssueService(BookIssueRepository bookIssueRepository) {
        this.bookIssueRepository = bookIssueRepository;
    }

    // CREATE
    public BookIssueEntity saveBookIssue(BookIssueEntity bookIssue) {
        return bookIssueRepository.addBookIssue(bookIssue);
    }

    // READ all
    public List<BookIssueEntity> getAllBookIssues() {
        return bookIssueRepository.getAll();
    }

    public List<BookIssueCount> getNMostIssuedBooks(int n) {
        List<BookIssueCount> bookIssueCounts = this.bookIssueRepository.getTopNIssuedBooks(n);
        return bookIssueCounts;
    }

    public List<BookEntity> getActiveBooksIssuedByUser(long userId) {
        return this.bookIssueRepository.getAllActiveBooksIssuedByUser(userId);
    }

    // READ by id
    public BookIssueEntity getBookIssueById(Long id) {
        return bookIssueRepository.getById(id);
    }

    // DELETE
    public void deleteBookIssue(Long id) {
        this.bookIssueRepository.deleteById(id);
    }
}
