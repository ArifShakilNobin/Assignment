package org.api.assignment_one.model;

import lombok.Data;

@Data
public class Promotion {
    private String type;
    private double discount;
    private String description;
}
