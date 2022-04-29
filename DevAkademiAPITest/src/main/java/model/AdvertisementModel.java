package model;

import lombok.Data;

public@Data
class AdvertisementModel {
    private int id;
    private String category;
    private int impressionCount;
    private int clickCount;
    private String content;
    private String contentType;
    private long createdDate;
}
