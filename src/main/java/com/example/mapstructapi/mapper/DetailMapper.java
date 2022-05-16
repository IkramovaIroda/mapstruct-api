package com.example.mapstructapi.mapper;

import com.example.mapstructapi.dto.DetailDTO;
import com.example.mapstructapi.entity.Detail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetailMapper {


    Detail toEntity(DetailDTO detailDTO);

    DetailDTO toDTO(Detail detail);
}
