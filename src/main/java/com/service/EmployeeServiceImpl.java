package com.service;

import java.util.List;
import java.util.Optional;

import com.dao.EmployeeDAOImpl;
import com.dto.Employee;




public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

	public Optional<Employee> addEmployee(Employee employee) {
		return employeeDAOImpl.addEmployee(employee);
	}

	public Optional<Employee> updateEmployee(Employee employee) {
		return employeeDAOImpl.updateEmployee(employee);
	}

	public Optional<Employee> getEmployeeById(Integer empId) {
		return employeeDAOImpl.getEmployeeById(empId);
	}

	public List<Employee> getEmployees() {
		return employeeDAOImpl.getEmployees();
	}

}
