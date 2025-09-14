package org.geeksforgeeks.jdbl86.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public int addTwoNumbers(int a, int b) {
        if (a < 0 && b < 0) {
            return 0;
        }
        return a + b;
    }
}

// a = 10, b = 10 | A: 20
// If expectedValue = actualValue (PASS) else (FAIL)

// Jacoco (plugin to give test report)
