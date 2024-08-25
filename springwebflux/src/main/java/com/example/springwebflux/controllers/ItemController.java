package com.example.springwebflux.controllers;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.models.Item;
import com.example.springwebflux.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/item")
public class ItemController{
    @Autowired
    private ItemServiceImpl itemServiceImpl;
    @GetMapping
    public Flux<Item> getAllItems() {
        return itemServiceImpl.getAll();
    }
    @GetMapping("/{id}")
    public Mono<Item> getItemById(@PathVariable Long id){
        return itemServiceImpl.getById(id);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteItemById(@PathVariable Long id){
        return itemServiceImpl.deleteById(id);
    }
    @PutMapping("/{id}")
    public Mono<Item> updateItemById(@RequestBody Item item){
        return itemServiceImpl.update(item);
    }
    @PostMapping
    public Mono<Item> addItem(@RequestBody ItemDTO item){
        return itemServiceImpl.save(item);
    }
}
