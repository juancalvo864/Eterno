package com.javasoft.eterno.repository;

import com.javasoft.eterno.entity.Product;
import com.javasoft.eterno.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product,Long> {

}
