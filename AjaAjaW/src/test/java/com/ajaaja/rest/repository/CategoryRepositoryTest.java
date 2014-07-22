package com.ajaaja.rest.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajaaja.rest.domain.Category;

public class CategoryRepositoryTest {

	CategoryRepository repo;
	
	@Before
	public void setup() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		repo = context.getBean(CategoryRepository.class);
	}
	
	@Test
	public void findByKeyword(){
		Category categoryProd = repo.findByKeyword("prod");
		assertNotNull(categoryProd);
	}
}
