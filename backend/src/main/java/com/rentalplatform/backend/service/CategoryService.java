package com.rentalplatform.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rentalplatform.backend.entity.Category;
import com.rentalplatform.backend.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repo;
    public List<Category> getAll(){
        return repo.findAll();
    }
    public Category create(Category category){
        return repo.save(category);
    }
}
