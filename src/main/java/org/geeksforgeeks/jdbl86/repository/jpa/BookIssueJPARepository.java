package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.db_response.BookIssueCount;
import org.geeksforgeeks.jdbl86.entity.BookIssueEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookIssueJPARepository extends JpaRepository<BookIssueEntity, Long> {

    // Java 17 and above
    @Query("""
            SELECT b.bookEntity AS book, COUNT(b.id) AS issueCount
            FROM BookIssueEntity b
            GROUP BY b.bookEntity
            ORDER BY COUNT(b.id) DESC
            """)
    List<BookIssueCount> findMostIssuedBooks(Pageable pageable);

    List<BookIssueEntity> findByUserEntity_IdAndExpiryDateGreaterThanEqual(long id, LocalDate expiryDate);

}
