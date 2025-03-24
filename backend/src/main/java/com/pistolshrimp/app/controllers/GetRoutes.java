package com.pistolshrimp.app.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.pistolshrimp.app.models.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


@RestController
public class GetRoutes {
    @Value("${aws.dynamodb.tableName}")
    private String tableName;
    private DynamoDbClient client = DynamoDbClient.builder().region(Region.EU_NORTH_1).build();

    /**
     * Get all logs from the DynamoDB table.
     * 
     * @return all logs in the table
     */
    @GetMapping("/logs")
    public List<Person> getLogs() {
        ScanResponse response = client.scan(ScanRequest.builder().tableName(tableName).build());
        List<Person> list = new ArrayList<>();
        for (Map<String, AttributeValue> item : response.items()) {
            Person person = new Person();
            person.setId(Integer.parseInt(item.get("id").n()));
            person.setName(item.get("name").s());
            list.add(person);
        }                                    
        return list;     
    }
}


