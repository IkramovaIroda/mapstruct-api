package com.example.mapstructapi.service;

import com.example.mapstructapi.dto.ApiResponse;
import com.example.mapstructapi.dto.ProductDTO;
import com.example.mapstructapi.entity.Product;
import com.example.mapstructapi.mapper.ProductMapper;
import com.example.mapstructapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductMapper productMapper;
    final ProductRepository productRepository;

    public ApiResponse add(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);
        return new ApiResponse("Added!", true);
    }

    //ishlamadi
    public ApiResponse getOne(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        ProductDTO productDTO = productMapper.toDTO(product);
        return new ApiResponse("Mana", true, productDTO);
    }

    //@Mapper(
    //      componentModel = "spring",
    //      unmappedTargetPolicy = ReportingPolicy.ERROR,
    //      uses = {AddressMapper.class})
    //public interface DoctorMapper {
    //
    //   @Mapping(source = "phone", target = "contact")
    //   @Mapping(source = "speciality.name", target = "specialityName")
    //   @Mapping(
    //         source = "patients",
    //         target = "numPatients",
    //         qualifiedByName = "countPatients")
    //   DoctorDto toDto(Doctor doctor);
    //
    //   @Named("countPatients")
    //   default int getNumPatients(List<Patient> patients) {
    //      if(patients == null) {
    //         return 0;
    //      }
    //      return patients.size();
    //   }
    //}
}
