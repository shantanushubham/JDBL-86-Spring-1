package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<BookEntity, Integer> {
}
