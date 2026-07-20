package com.example.spring_devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_devops.models.Employee;


@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
