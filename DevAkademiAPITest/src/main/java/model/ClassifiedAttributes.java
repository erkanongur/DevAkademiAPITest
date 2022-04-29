package model;

import lombok.Data;

public@Data class ClassifiedAttributes {
    private int id;
    private int classifiedId;
    private String attributeName;
    private String attributeValue;
}
