package com.example.programador.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.programador.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
