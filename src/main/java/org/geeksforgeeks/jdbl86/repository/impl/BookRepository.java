package org.geeksforgeeks.jdbl86.repository.impl;

import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.jpa.BookJPARepository;
import org.springframework.stereotype.Repository;


@Repository
public class BookRepository {

    private final BookJPARepository bookJPARepository;

    public BookRepository(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    public BookEntity getBookById(int bookId) {
        return this.bookJPARepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookEntity.class, "id", bookId));

    }
}
