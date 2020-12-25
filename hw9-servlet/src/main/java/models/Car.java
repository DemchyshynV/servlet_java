package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car {

    private int id;
    private String model;
    private String color;
    private String producer;
    private String ownerNickname;
    private int ownerAge;
}
