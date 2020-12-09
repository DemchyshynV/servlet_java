package products;

import lombok.*;
import products.enums.ProductType;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product {

    private int id;
    private String name;
    private double price;
    private ProductType type;
    private String producer;
    private String color;

}
