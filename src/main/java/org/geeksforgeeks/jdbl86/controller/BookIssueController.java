package org.geeksforgeeks.jdbl86.controller;

import org.geeksforgeeks.jdbl86.db_response.BookIssueCount;
import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.service.BookIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book_issue")
public class BookIssueController {

    private final BookIssueService bookIssueService;

    public BookIssueController(BookIssueService bookIssueService) {
        this.bookIssueService = bookIssueService;
    }

    @GetMapping("/top/{n}")
    public List<BookIssueCount> getTopNIssuedBooks(@PathVariable int n) {
        return this.bookIssueService.getNMostIssuedBooks(n);
    }

    @GetMapping("/user/{userId}")
    public List<BookEntity> getActiveBooksByUser(@PathVariable long userId) {
        return this.bookIssueService.getActiveBooksIssuedByUser(userId);
    }
}
