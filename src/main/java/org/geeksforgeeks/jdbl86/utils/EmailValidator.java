package org.geeksforgeeks.jdbl86.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    // Regex pattern for common email formats (not strictly RFC-compliant, but practical)
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates an email address using a practical regex pattern.
     * * @param email The email address to validate.
     * @return true if the email is valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Examples
        System.out.println("test@example.com: " + isValidEmail("test@example.com")); // true
        System.out.println("user.name+tag@sub.domain.co.uk: " + isValidEmail("user.name+tag@sub.domain.co.uk")); // true
        System.out.println("invalid-email: " + isValidEmail("invalid-email")); // false
        System.out.println("test@.com: " + isValidEmail("test@.com")); // false
    }
}
