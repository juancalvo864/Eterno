package com.javasoft.eterno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "nombre")
        private String name;
        @Column(name = "codigo_oem",nullable = false,unique = true)
        private String codeOem;
        @Column(name = "codigo_int",nullable = false,unique = true)
        private String codeInt;
        @Column(name = "proveedor")
        private String supplier;
        @Column(name = "costo")
        private Double cost;
        @Column(name = "precio")
        private Double price;
        @Column(name = "iva")
        private Double tax;
        @Column(name = "stock")
        private int stock;
        @Column(name = "stock_min")
        private int stockMin;
        @Column(name = "imagen_prod")
        private byte[] image;
        @Column(name = "habilitado")
        private boolean active = true;
    }
