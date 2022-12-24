package com.ensamvol.service;

import com.ensamvol.entities.Employee;
import com.ensamvol.entities.Personne;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface EmployeeService {
    void addNewEmployee(Employee employee);
    List<Employee> listEmployee();
    void removeEmployee(Long idEmployee);
    void saveEmployee(Employee employee);
    Personne loadUserEmployee(int id);
}
