package com.example.mapstructapi.mapper;

import com.example.mapstructapi.dto.ProductDTO;
import com.example.mapstructapi.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {DetailMapper.class})
public interface ProductMapper {

    @Mapping(source = "detailDTOS", target = "detailList")
    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDTO productDTO);

    @Mapping(source = "detailList", target = "detailDTOS")
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDTO(Product product);



}
