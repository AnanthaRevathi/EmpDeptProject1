package com.excelr.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Department {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;

	    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Employee> employees;
	    
	    public Department() 
	    {
	    	
	    }
	    
	    
	    public Department(int id, String name, List<Employee> employees) {
	    	super();
	    	this.id = id;
	    	this.name = name;
	    	this.employees = employees;
	    }
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<Employee> getEmployees() {
	        return employees;
	    }

	    public void setEmployees(List<Employee> employees) {
	        this.employees = employees;
	    }
	
}

