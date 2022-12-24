package com.ensamvol.service;

import com.ensamvol.entities.Employee;
import com.ensamvol.entities.Personne;
import com.ensamvol.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeImp implements EmployeeService {
    final EmployeeRepository employeeRepository;
    final AccountService accountService;

    public  EmployeeImp(EmployeeRepository employeeRepository, AccountService accountService) {
        this.employeeRepository = employeeRepository;
        this.accountService = accountService;
    }



    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void removeEmployee(Long idEmployee) {
        employeeRepository.deleteEmployeeById(idEmployee);

    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public Personne loadUserEmployee(int idEmployee) {
        return accountService.showUserById(idEmployee);
    }



}
