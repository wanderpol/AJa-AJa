package com.ajaaja.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajaaja.rest.domain.Category;
import com.ajaaja.rest.domain.Product;
import com.ajaaja.rest.repository.CategoryRepository;


public class InitialData {

	CategoryRepository repo;
	
	@Before
	public void setup() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		repo = context.getBean(CategoryRepository.class);
		
		repo.deleteAll();
	}
	
	
	@Test
	public void test(){
		for(int i=0 ; i<10000 ; i++){
			List<Product> products = new ArrayList<Product>();
			for(int j=0 ; j<10 ; j++){
				products.add(new Product("prod"+j, "company"+i));
			}
			Category category = new Category("keyword"+i, products);
			repo.save(category);
			//	"keyword"+i,
			//new ArrayList<Product>(){
			//		{ add(new Product("prod", "comp"+i)); }
			//	};
		}
	}
	
	@Test
	public void cleanup(){
		
	}
}
