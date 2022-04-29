package model;

import lombok.Data;

//PaymentDetailModel Sınıfı bir POJO Sınıfıdır.
//İlgili API Ucunun Yanıtını Haritalamak İçin Kullanılmaktadır.
public@Data
class PaymentDetailModel {
    private int id;
    private int classifiedId;
    private long createdDate;
    private double amount;
    private double discount;
}
