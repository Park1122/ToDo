package com.example.todo.item.service;

import com.example.todo.item.dto.ItemResponse;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    List<ItemResponse> getItemList(Long categoryId);

    ItemResponse modifyItem(Long itemId, String content, LocalDate date);
}
