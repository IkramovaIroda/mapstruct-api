package com.example.mapstructapi.mapper;

import com.example.mapstructapi.dto.CategoryDTO;
import com.example.mapstructapi.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//bean
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "active", target = "act")
    @Mapping(source = "name", target = "nomi")
    CategoryDTO toDTO(Category category);

    @Mapping(source = "act", target = "active")
    @Mapping(source = "nomi", target = "name")
    Category toEntity(CategoryDTO dto);


    List<CategoryDTO> toDtoList(List<Category> categoryDTOList);

}
