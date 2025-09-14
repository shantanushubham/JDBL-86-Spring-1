package org.geeksforgeeks.jdbl86.db_response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.geeksforgeeks.jdbl86.entity.BookEntity;

@JsonDeserialize
@JsonSerialize
public record BookIssueCount(BookEntity bookEntity, long issueCount) {}