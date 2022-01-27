package com.example.todo.item.dto;

import com.example.todo.category.domain.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ItemResponse {
    private Long id;
    private String content;
    private LocalDate date;
    private boolean bookMark;
    private boolean done;
    private Category categoryId;
}
