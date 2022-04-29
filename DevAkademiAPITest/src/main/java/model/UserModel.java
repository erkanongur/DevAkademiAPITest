package model;

import lombok.Data;

//UserModel Sınıfı bir POJO Sınıfıdır.
//İlgili API Ucunun Yanıtını Haritalamak İçin Kullanılmaktadır.
public @Data
class UserModel {
    private int id;
    private String firstName;
    private String lastName;
    private String status;
}
