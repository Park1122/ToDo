package com.example.todo.item.service;

import com.example.todo.item.domain.Item;
import com.example.todo.item.dto.ItemResponse;
import com.example.todo.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemResponse> getItemList(Long categoryId) {
        List<Item> items = this.itemRepository.findAllById(categoryId);
        List<ItemResponse> res = new ArrayList<>();
        for (Item item : items) {
            res.add(ItemResponse.builder()
                    .id(item.getId())
                    .content(item.getContent())
                    .date(item.getDate())
                    .bookMark(item.isBookMark())
                    .done(item.isDone())
                    .categoryId(item.getCategoryId())
                    .build());
        }
        return res;
    }

    @Transactional
    @Override
    public ItemResponse modifyItem(Long itemId, String content, LocalDate date) {
        Item item = this.itemRepository.findById(itemId).orElseThrow(() -> new NoSuchElementException());
        item.setContent(content);
        item.setDate(date);
        final Item modifiedItem = this.itemRepository.save(item);
        return ItemResponse.builder()
                .id(modifiedItem.getId())
                .content(modifiedItem.getContent())
                .date(modifiedItem.getDate())
                .bookMark(modifiedItem.isBookMark())
                .done(modifiedItem.isDone())
                .categoryId(modifiedItem.getCategoryId())
                .build();
    }
}
