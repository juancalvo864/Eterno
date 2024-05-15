package com.javasoft.eterno.controller;

import com.javasoft.eterno.dto.EmployeeDTO;
import com.javasoft.eterno.dto.ProductDTO;
import com.javasoft.eterno.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    //Crear producto
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO savedProduct = productService.createProduct(productDTO);
    return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    //Consultar producto por Id
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long productId){
        ProductDTO product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }
    //Consultar todos los productos
    @GetMapping
    public  ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products= productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
}
