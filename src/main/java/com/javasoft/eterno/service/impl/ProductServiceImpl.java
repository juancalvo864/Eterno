package com.javasoft.eterno.service.impl;

import com.javasoft.eterno.dto.ProductDTO;
import com.javasoft.eterno.entity.Product;
import com.javasoft.eterno.exception.ResourceNotFoundException;
import com.javasoft.eterno.mapper.ProductMapper;
import com.javasoft.eterno.repository.ProductRepository;
import com.javasoft.eterno.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.mapToProduct(productDTO);
        Product saveProduct = productRepository.save(product);
        return null;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product is not exist with given is: " + productId));
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product)-> ProductMapper.mapToProductDTO(product)).collect(Collectors.toList());
    }

}
