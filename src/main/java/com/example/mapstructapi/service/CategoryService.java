package com.example.mapstructapi.service;

import com.example.mapstructapi.dto.ApiResponse;
import com.example.mapstructapi.dto.CategoryDTO;
import com.example.mapstructapi.entity.Category;
import com.example.mapstructapi.mapper.CategoryMapper;
import com.example.mapstructapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        categoryRepository.save(category);
        return new ApiResponse("Added", true);
    }

//    public ApiResponse getAll(){
//        List<Category> all = categoryRepository.findAll();
//    }

    public ApiResponse getOne(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.get();
        CategoryDTO categoryDTO = categoryMapper.toDTO(category);

        return new ApiResponse("Mana", true, categoryDTO);
    }

}
