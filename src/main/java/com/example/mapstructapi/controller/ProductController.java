package com.example.mapstructapi.controller;

import com.example.mapstructapi.dto.ApiResponse;
import com.example.mapstructapi.dto.ProductDTO;
import com.example.mapstructapi.entity.Product;
import com.example.mapstructapi.mapper.ProductMapper;
import com.example.mapstructapi.repository.ProductRepository;
import com.example.mapstructapi.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductRepository productRepository;
    final ProductService productService;
    final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        ApiResponse add = productService.add(productDTO);
        return ResponseEntity.ok().body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse response = productService.getOne(id);
        return ResponseEntity.ok().body(response);
    }

//    @GetMapping
//    public ResponseEntity<?> getAll() {
//        List<Product> all = productRepository.findAll();
//
//
//    }

}

