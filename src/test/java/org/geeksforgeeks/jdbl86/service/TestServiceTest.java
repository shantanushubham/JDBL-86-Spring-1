package org.geeksforgeeks.jdbl86.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    void testAddTwoNumbers_whenSumIsCorrect() {
        int a = 10;
        int b = 20;

        int sum = this.testService.addTwoNumbers(a, b);
        Assertions.assertEquals(30, sum);
    }

    @Test
    void testAddTwoNumbers_whenTheNumbersAreNegative() {
        int a = -10;
        int b = -20;

        int sum = this.testService.addTwoNumbers(a, b);
        Assertions.assertEquals(0, sum);
    }

    @Test
    void testAddNumbers_whenOneIsNegative() {
        int a = -10;
        int b = 20;

        int sum = this.testService.addTwoNumbers(a, b);
        Assertions.assertEquals(10, sum);
    }
}
