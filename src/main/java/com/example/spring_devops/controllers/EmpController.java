package com.example.spring_devops.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring_devops.models.Employee;
import com.example.spring_devops.services.emp_int;

//import com.example.demo.dtos.UserProfile;
//import com.example.demo.models.User;
//import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/employees")
public class EmpController {

	
	@Autowired
    private emp_int us;
	
    @GetMapping
    public List<Employee> getAllUsers() {
    	return this.us.getAllUsers();
   
    }
    
//    @GetMapping("/age/{age}/salary/{salary}")
//    public String getUserByAge(@PathVariable int age, @PathVariable int salary) {
//    	return "fetching user with id "+age+" "+salary;
//    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getUserById(@PathVariable int id) {
    	Optional<Employee> found_User=this.us.getUserById(id);
    	if(found_User!=null) {
    		return ResponseEntity.ok(found_User);
    	}
    	return ResponseEntity.notFound().build();
    }
    
//    @GetMapping("/profile")
//    public ResponseEntity<UserProfile> getProfile(HttpServletRequest request){
//    	Integer id = (Integer) request.getAttribute("id");
//    	Optional<User> foundUser=  this.us.getUserById(id);
//    	
//    	User newUser=foundUser.get();
//    	UserProfile profile=new UserProfile(newUser.getId(), newUser.getName(), newUser.getEmail());
//    	return ResponseEntity.ok(profile);
//    }
    
    @PostMapping("/signup")
    public Employee signup(@ModelAttribute Employee newUser) {
    	System.out.println(newUser);
    	return this.us.insertUser(newUser);
    	
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
    	this.us.deleteById(id);
    	System.out.println("user deleted");
    }
    
    @PutMapping
    public Employee updateUser(@ModelAttribute Employee modUser,int id) {
    	Employee updatedUser=this.us.updateUser(modUser,id);
    	return updatedUser;
    }
}
