package model;

import lombok.Data;

import java.util.List;

public@Data
class ClassifiedModel {
    private int id;
    private int userId;
    private String title;
    private String description;
    private String currency;
    private Double price;
    private String status;
    private long createdDate;
    private String publishedBy;
    private String city;
    private String category;
    private List<ClassifiedAttributes> classifiedAttributes;
    private Coordinate coordinate;
}
