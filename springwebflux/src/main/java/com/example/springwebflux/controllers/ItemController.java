package com.example.springwebflux.controllers;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.models.Item;
import com.example.springwebflux.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public Mono<ResponseEntity<String>> deleteItemById(@PathVariable Long id){
        itemServiceImpl.deleteById(id);
        return Mono.just(ResponseEntity.status(HttpStatus.ACCEPTED).body("Item deleted"));
    }
    @PutMapping("/{id}")
    @Transactional
    public Mono<Item> updateItemById(@RequestBody Item item){
        return itemServiceImpl.update(item);
    }
    @PostMapping
    public Mono<Item> addItem(@RequestBody ItemDTO item){
        return itemServiceImpl.save(item);
    }
}
