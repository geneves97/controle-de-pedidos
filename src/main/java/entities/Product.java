package entities;

import lombok.Data;

@Data
public class Product {

    private String name;
    private Double price;

    public Product(){}

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
