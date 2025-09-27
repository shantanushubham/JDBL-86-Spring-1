package org.geeksforgeeks.jdbl86.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.geeksforgeeks.jdbl86.enums.SubscriptionType;

import java.time.LocalDate;

@JsonDeserialize
@JsonSerialize

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    // if the value entered is a correct email or not
    @Column(name = "email", nullable = false, unique = true)
    // if the email is duplicate or not in DB
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;

    // in DB table, this field will be int
    @Column(name = "subscription_type", nullable = false)
    private SubscriptionType subscriptionType = SubscriptionType.NOT_SUBSCRIBED;
}
