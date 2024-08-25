package com.example.springwebflux.services.impl;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.mappers.ItemAndItemDTO;
import com.example.springwebflux.models.Item;
import com.example.springwebflux.repositories.ItemRepository;
import com.example.springwebflux.services.ItemService;
import com.example.springwebflux.services.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private ItemAndItemDTO itemAndItemDTO = new ItemAndItemDTO();


    @Override
    public Mono<Item> save(ItemDTO itemDTO) {
    return itemRepository.save(itemAndItemDTO.itemDTOToItem(itemDTO));
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
    public Mono<Item> update(Item item) {
        return getById(item.getId()).flatMap((existedItem)->{
            existedItem.setTitle(item.getTitle());
            return itemRepository.save(item);
        });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
      return  itemRepository.deleteById(id).doOnSuccess(
                itemFound -> System.out.println("Item deleted successfully")
        ).doOnError(
               error -> new ItemNotFoundException("Item with id: " + id + " not found")
        );
    }
}
