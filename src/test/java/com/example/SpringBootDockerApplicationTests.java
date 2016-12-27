package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDockerApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Context will be loaded whenever we run our application");
	}
	
	@Test
	public void validateUser()
	{
			String temp="<h3><center>Hello anjaneyulu! Welcome to your Spring Boot Docker Application</center></h3>";
			assertEquals(temp, new SpringBootDockerApplication().greeting("anjaneyulu"));
	}
}
