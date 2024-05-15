package com.javasoft.eterno.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String codeOem;

    private String codeInt;

    private String supplier;

    private Double cost;

    private Double price;

    private Double tax;

    private int stock;

    private int stockMin;
    private byte[] image;
    private boolean active = true;
}
