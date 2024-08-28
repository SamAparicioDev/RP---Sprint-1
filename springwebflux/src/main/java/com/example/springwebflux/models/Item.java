package com.example.springwebflux.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("item")
@ToString
@Getter
public class Item {
    @Id
    private Long id;
    @Setter
    private String title, description;
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
