package com.ensamvol.service;

import com.ensamvol.HelperClass.EmployeeHelper;
import com.ensamvol.entities.Employee;
import com.ensamvol.entities.Personne;
import com.ensamvol.entities.Role;
import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
@Service
@Transactional
public class EmployeeImp implements EmployeeService {
	@Autowired
    private  EmployeeRepository employeeRepository;
	@Autowired

    private AccountService accountService;
	@Autowired

    private AppUserRepository appUserRepository;
	@Autowired

    private  AppRoleRepository appRoleRepository;

 



    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void removeEmployee(Integer idEmployee) {
        employeeRepository.deleteEmployeeByIdEmployee(idEmployee);

    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public Personne loadUserEmployee(int idEmployee) {
        return accountService.showUserById(idEmployee);
    }



	@Override
	public void updateEmployee(EmployeeHelper employeeHelper) {
		Employee oldEmployee = employeeRepository.findByIdEmployee(employeeHelper.idEmployee);
		int CIN=employeeHelper.getCIN();
		String nom = employeeHelper.getNom();
		String prenom = employeeHelper.getPrenom();
		String dateNaissance = employeeHelper.getDateNaissance();
		String username = employeeHelper.getUsername();
		String password = employeeHelper.getPassword();
		Role role= appRoleRepository.findByRoleName(employeeHelper.getRoleName());
		List<Role> roles=new ArrayList<>();
		roles.add(role);
		oldEmployee.personne.setCIN(CIN);
		oldEmployee.personne.setNom(nom);
		oldEmployee.personne.setPrenom(prenom);
		oldEmployee.personne.setDateNaissance(dateNaissance);
		oldEmployee.personne.setUsername(username);
		oldEmployee.personne.setPassword(password);
		oldEmployee.personne.setRoles(roles);
		employeeRepository.save(oldEmployee);
	}



}
