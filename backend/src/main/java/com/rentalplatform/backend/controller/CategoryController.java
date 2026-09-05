package com.rentalplatform.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalplatform.backend.entity.Category;
import com.rentalplatform.backend.service.CategoryService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    @GetMapping
    public List<Category> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return service.create(category);
    }

}
