package com.javasoft.eterno.service;

import com.javasoft.eterno.dto.EmployeeDTO;
import com.javasoft.eterno.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long productId);

    List<ProductDTO> getAllProduct();



}
