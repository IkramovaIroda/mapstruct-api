package com.example.mapstructapi.controller;

import com.example.mapstructapi.dto.ApiResponse;
import com.example.mapstructapi.dto.CategoryDTO;
import com.example.mapstructapi.entity.Category;
import com.example.mapstructapi.mapper.CategoryMapper;
import com.example.mapstructapi.repository.CategoryRepository;
import com.example.mapstructapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;


    @PostMapping
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO) {
        ApiResponse response = categoryService.add(categoryDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        ApiResponse response = categoryService.getOne(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getALL() {
        List<Category> all = categoryRepository.findAll();
        List<CategoryDTO> dtoList = categoryMapper.toDtoList(all);
        return ResponseEntity.ok(dtoList);
    }

}
