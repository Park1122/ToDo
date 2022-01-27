package com.example.todo.item.controller;

import com.example.todo.item.dto.ItemResponse;
import com.example.todo.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getItemList(@RequestParam(name="categoryId") Long categoryId) {
        return ResponseEntity.ok(this.itemService.getItemList(categoryId));
    }

    @PutMapping
    public ResponseEntity<ItemResponse> modifyItem(@RequestParam(name="itemId") Long itemId
            , @RequestParam(name="content") String content, @RequestParam(name="date") LocalDate date) {
        return ResponseEntity.ok(this.itemService.modifyItem(itemId, content, date));
    }

}
