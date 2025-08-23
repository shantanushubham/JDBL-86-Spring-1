package org.geeksforgeeks.jdbl86.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@JsonDeserialize
@JsonSerialize

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@With
public class Food {

    private int id;
    private String name;

}
