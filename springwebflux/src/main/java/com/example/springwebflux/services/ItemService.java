package com.example.springwebflux.services;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.models.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
    Mono<Item> save(ItemDTO item);
    Mono<Item> getById(Long id);
    Flux<Item> getAll();
    Mono<Item> update(Long id,Item item);
    Mono<Void> deleteById(Long id);
}
