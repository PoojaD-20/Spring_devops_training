package com.example.spring_devops.services;

import java.util.List;
import java.util.Optional;

import com.example.spring_devops.models.Employee;


public interface emp_int {
	
    public List<Employee> getAllUsers();
	
	public Optional<Employee> getUserById(int id);
	
	public Employee insertUser(Employee emp);
	
	public void deleteById(int id);
	
	public Employee updateUser(Employee emp,int id);

}
