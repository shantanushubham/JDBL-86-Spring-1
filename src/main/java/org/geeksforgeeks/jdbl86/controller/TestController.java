package org.geeksforgeeks.jdbl86.controller;

import org.geeksforgeeks.jdbl86.ex.Food;
import org.geeksforgeeks.jdbl86.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public void sayHello() {
        this.testService.sayHello();
    }

    @GetMapping("/test")
    public String test() {
        this.sayHello();
        return "/ executed";
    }

    @GetMapping("/get_item")
    public Food makePizza(@RequestParam int id) throws IOException {
        return this.testService.getFoodById(id);
    }

    @PostMapping("/add_item")
    public ResponseEntity<?> addFood(@RequestBody Food foodToAdd) {
        System.out.println(foodToAdd);
        Food f = new Food(10, "Test Food");
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

}
