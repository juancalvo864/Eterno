package com.javasoft.eterno.mapper;

import com.javasoft.eterno.dto.ProductDTO;
import com.javasoft.eterno.entity.Product;

public class ProductMapper {
    public static ProductDTO mapToProductDTO (Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getCodeOem(),
                product.getCodeInt(),
                product.getSupplier(),
                product.getCost(),
                product.getPrice(),
                product.getTax(),
                product.getStock(),
                product.getStockMin(),
                product.getImage(),
                product.isActive()
                );
    }
    public static Product mapToProduct(ProductDTO productDTO){
        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getCodeOem(),
                productDTO.getCodeInt(),
                productDTO.getSupplier(),
                productDTO.getCost(),
                productDTO.getPrice(),
                productDTO.getTax(),
                productDTO.getStock(),
                productDTO.getStockMin(),
                productDTO.getImage(),
                productDTO.isActive()

        );
    }

}
