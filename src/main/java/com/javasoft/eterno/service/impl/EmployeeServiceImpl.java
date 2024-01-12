package com.javasoft.eterno.service.impl;

import com.javasoft.eterno.dto.EmployeeDTO;
import com.javasoft.eterno.entity.Employee;
import com.javasoft.eterno.mapper.EmployeeMapper;
import com.javasoft.eterno.repository.EmployeeRepository;
import com.javasoft.eterno.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        return null;
    }
}
