package com.example.springwebflux.repositories;

import com.example.springwebflux.models.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item,Long> {
}
