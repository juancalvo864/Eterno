package com.javasoft.eterno.mapper;

import com.javasoft.eterno.dto.EmployeeDTO;
import com.javasoft.eterno.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAddress()
        );

    }
    public static   Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getAddress()
        );
    }
}
