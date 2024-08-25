package com.example.springwebflux.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("item")
@ToString
public class Item {
    @Id
    @Getter
    private Long id;
    @Getter
    @Setter
    private String title, description;
    @Getter
    @Setter
    private Double price;
    public Item() {

    }
    public Item(String title,String description,Double price){
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
