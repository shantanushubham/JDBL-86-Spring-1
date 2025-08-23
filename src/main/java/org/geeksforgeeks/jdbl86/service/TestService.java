package org.geeksforgeeks.jdbl86.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.geeksforgeeks.jdbl86.config.GoogleDrive;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.model.Food;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class TestService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public GoogleDrive googleDrive;

    public TestService(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    public Food getFoodById(int id) throws IOException {
        List<Food> foodList = this.objectMapper.readValue(
                new File("src/hello.json"),
                new TypeReference<>() {
                });
        List<Food> foundFood = foodList.stream().filter(it -> it.getId() == id).toList();
        if (foundFood.isEmpty()) {
            throw new NotFoundException(Food.class, "id", id);
        }
        Food food = foodList.get(0);
        log.info("Food with id:{} was found", id);
        return food;
    }

    public void sayHello() {
        this.googleDrive.upload(new File("/src/hello.json"));
        System.out.println("Hello world");
    }

}
