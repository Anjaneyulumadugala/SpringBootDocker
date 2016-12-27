package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.EmployeeSearch;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {
	EmployeeSearch emp=new EmployeeSearch();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	if(emp.searchEmployee(name))
    	{
    		return "<h3><center>Hello "+name+"! Welcome to your Spring Boot Docker Application</center></h3>";
    	}
    	return "<h3><center>Hello World! This is Spring Boot Docker Example</center></h3>";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

}