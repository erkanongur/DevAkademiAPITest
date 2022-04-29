package model;

import lombok.Data;

public@Data
class AccessLogModel {
    private int id;
    private int userId;
    private String endpoint;
    private long createdDate;
}
