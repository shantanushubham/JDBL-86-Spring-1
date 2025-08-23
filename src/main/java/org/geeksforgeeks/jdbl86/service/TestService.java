package org.geeksforgeeks.jdbl86.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geeksforgeeks.jdbl86.config.GoogleDrive;
import org.geeksforgeeks.jdbl86.ex.Food;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class TestService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public GoogleDrive googleDrive;

    public TestService(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    public Food getFoodById(int id) throws IOException {
        List<Food> foodList = this.objectMapper.readValue(
                new File("src/hello.json"),
                new TypeReference<>() {});
        Food food = foodList.stream().filter(it -> it.getId() == id).toList().get(0);
        return food;
    }

    public void sayHello() {
        this.googleDrive.upload(new File("/src/hello.json"));
        System.out.println("Hello world");
    }

    // teaching only
    void test() {
        Food food = Food.builder()
                .name("Dosa")
                .build();

       // You need a copy of the food object but the name should be Idli
        Food food1 = food.withName("Idli");
    }

}
