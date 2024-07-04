package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.EmployeeRepository;
import com.excelr.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
private EmployeeRepository empRepo;
	//insert the employee
		public Employee insertEmp(Employee emp)
		{
			return empRepo.save(emp);
		}
		
		public List <Employee> getAllEmp(){
			return empRepo.findAll();
		}
		//update Emp
				public Employee updateEmp(int id,Employee emp)
				{
					Employee e1=empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
					e1.setName(emp.getName());
					e1.setSalary(emp.getSalary());
			        e1.setDepartment(emp.getDepartment());
					return empRepo.save(e1);
				}
				
				//deleting emp
				public void deleteEmp(int id)
				{
					Employee emp=empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
					empRepo.delete(emp);
				}
}
