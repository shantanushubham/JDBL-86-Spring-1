package org.geeksforgeeks.jdbl86.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptUtil {

    private static BCrypt bCrypt;
    private static final String salt = BCrypt.gensalt(12);

    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
