package com.javasoft.eterno.repository;

import com.javasoft.eterno.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
