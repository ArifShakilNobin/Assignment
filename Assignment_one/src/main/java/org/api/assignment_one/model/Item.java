package org.api.assignment_one.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;
    private String storeName;
    private String distance;
    private double rating;
    private List<Promotion> promotions;
}