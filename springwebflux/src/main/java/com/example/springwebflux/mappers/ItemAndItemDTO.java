package com.example.springwebflux.mappers;


import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.models.Item;
import org.springframework.context.annotation.ComponentScan;

public class ItemAndItemDTO {
    public Item itemDTOToItem(ItemDTO itemDTO) {
        return new Item(itemDTO.title(),itemDTO.description(),itemDTO.price());
    }
    public ItemDTO itemToItemDTO(Item item) {
        return new ItemDTO(item.getTitle(),item.getDescription(),item.getPrice());
    }
}
