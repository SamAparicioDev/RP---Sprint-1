package com.example.springwebflux.services.impl;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.mappers.ItemAndItemDTO;
import com.example.springwebflux.models.Item;
import com.example.springwebflux.repositories.ItemRepository;
import com.example.springwebflux.services.ItemService;
import com.example.springwebflux.services.exceptions.ItemEmptyAnyField;
import com.example.springwebflux.services.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private ItemAndItemDTO itemAndItemDTO = new ItemAndItemDTO();


    @Override
    @Transactional
    public Mono<Item> save(ItemDTO itemDTO) {
        return Mono.just(itemDTO).flatMap((adquiredItem) -> {
            if (adquiredItem.description().isEmpty()|| adquiredItem.price() == null ) {
                return Mono.error(new ItemEmptyAnyField("Despcription is empty"));
            }
            if (adquiredItem.price() < 0 || adquiredItem.price() == null) {
               return  Mono.error(new ItemEmptyAnyField("Price is empty"));
            }
            if (adquiredItem.title().isEmpty() || adquiredItem.price() == null) {
                return Mono.error(new ItemEmptyAnyField("Title is empty"));
            }
            return itemRepository.save(itemAndItemDTO.itemDTOToItem(adquiredItem));
        });
    }

    @Override
    public Mono<Item> getById(Long id) {
        return itemRepository.findById(id).switchIfEmpty(Mono.error(new ItemNotFoundException("Id has empty item")));
    }

    @Override
    public Flux<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Mono<Item> update(Long id,Item item) {
        return getById(id).flatMap((existedItem)->{
            existedItem.setTitle(item.getTitle());
            existedItem.setPrice(item.getPrice());
            existedItem.setDescription(item.getDescription());
            return itemRepository.save(existedItem);
        });
    }


    @Override
    public Mono<Void> deleteById(Long id) {
       Mono<Void> operationToDelete = itemRepository.deleteById(id).doOnError(
                error -> new ItemNotFoundException("Item with id: " + id + " not found")
        );
       operationToDelete.subscribe();
       return Mono.just(operationToDelete).then();
    }
}
