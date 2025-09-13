package org.geeksforgeeks.jdbl86.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;

@JsonSerialize
@JsonDeserialize

@Data
public class BookIssueDto {

    private int userId;
    private int bookId;
    private LocalDate issueDate = LocalDate.now();

}
