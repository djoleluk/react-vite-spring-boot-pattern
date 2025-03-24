package com.pistolshrimp.app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import com.pistolshrimp.app.models.Person;

@RestController
public class PostRoutes {
    @Value("${aws.dynamodb.tableName}")
    private String tableName;
    DynamoDbClient client = DynamoDbClient.builder().region(Region.EU_NORTH_1).build(); 
    
    /**
     * Insert an item into the DynamoDB table specified by the tableName property.
     * The item is created from the given Person object.
     * @param person the Person object to create an item from
     * @return a string describing the inserted item
     */
    @PostMapping("/insert-item")
    public String insertItem(@RequestBody Person person) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().n(String.valueOf(person.getId())).build());
        item.put("name", AttributeValue.builder().s(person.getName() + "").build());
        client.putItem(PutItemRequest.builder().tableName(tableName).item(item).build());
        return "Inserted item: " + item;
    }
}


