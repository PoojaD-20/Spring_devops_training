package com.example.spring_devops.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.models.User;
//import com.example.demo.repositories.UsersRepository;
import com.example.spring_devops.models.Employee;
import com.example.spring_devops.repositories.EmpRepository;
import com.example.spring_devops.services.emp_int;

@Service
public class emp_ser_impl implements emp_int {
	
	@Autowired
	private EmpRepository er;
	
	private List<Employee> emps=new ArrayList<>();

	@Override
	public List<Employee> getAllUsers() {
		// TODO Auto-generated method stub
		return this.er.findAll();
	}

	@Override
	public Optional<Employee> getUserById(int id) {
		// TODO Auto-generated method stub
		for(Employee emp:emps) {
			if(emp.getId()==id) {
				return er.findById(id);
				//return ur.getById(id);
			}
		}
		return null;
	}

	@Override
	public Employee insertUser(Employee newEmp) {
		// TODO Auto-generated method stub
		Employee createdEmp= this.er.save(newEmp);
		return createdEmp;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if(er.existsById(id)) {
			er.deleteById(id);
			System.out.println("user deleted");
		}
		else {
			System.out.println("user with id not found");
		}
	}

	@Override
	public Employee updateUser(Employee emp, int id) {
		// TODO Auto-generated method stub
		Employee modEmp=null;
		// TODO Auto-generated method stub
		if(er.existsById(id)) {
			modEmp=er.save(emp);
		}
		return modEmp;
	}

}
