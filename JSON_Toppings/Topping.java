package com.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Topping {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final String FILE_PATH = "D:\\Coding\\JAVA\\Codes\\Spring Boot Applications\\bootrestapi\\src\\main\\resources\\donut.json";
    public static final String UPDATE_FILE_PATH = "D:\\Coding\\JAVA\\Codes\\Spring Boot Applications\\bootrestapi\\src\\main\\resources\\update_donut.json";

    public static void main(String[] args) throws IOException {
        try {
            // Read JSON from the file
            JsonNode donutNode = objectMapper.readTree(new File(FILE_PATH));
            JsonNode new_donutNode = objectMapper.readTree(new File(UPDATE_FILE_PATH));

            // First adding all the data to updated JSON file
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(UPDATE_FILE_PATH),donutNode);

            // Add topping to the first donut
            addTopping(new_donutNode.get(0), "6002", "Cherry");

            // Remove topping from the first donut
            removeTopping(new_donutNode.get(0), "5001");

            // write modified JSON back to the new updated file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(UPDATE_FILE_PATH), new_donutNode);

            System.out.println("Updated JSON written to file successfully!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTopping(JsonNode donut, String toppingId, String toppingType) {
        ArrayNode toppings = (ArrayNode) donut.get("topping");
        ObjectNode newTopping = objectMapper.createObjectNode();
        newTopping.put("id", toppingId);
        newTopping.put("type", toppingType);
        toppings.add(newTopping);
    }

    private static void removeTopping(JsonNode donut, String toppingId) throws IOException {
        ArrayNode toppings = (ArrayNode) donut.get("topping");

        // Create a list of indices to remove the specified topping
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).get("id").asText().equals(toppingId)) {
                toppings.remove(i);
                break; // Break after removing to avoid ConcurrentModificationException
            }
        }
    }
}