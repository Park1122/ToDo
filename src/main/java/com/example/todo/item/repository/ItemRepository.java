package com.example.todo.item.repository;

import com.example.todo.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllById(Long categoryId);
}
