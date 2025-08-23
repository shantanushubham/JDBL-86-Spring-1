package org.geeksforgeeks.jdbl86.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@JsonSerialize
@JsonDeserialize
public class ErrorResponse {

    private String message;
}
