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
@Table(name = "empleados")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "primer_nombre")
    private String firstName;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "email_id",nullable = false,unique = true)
    private String email;
    @Column(name = "domicilio")
    private String address;

}
