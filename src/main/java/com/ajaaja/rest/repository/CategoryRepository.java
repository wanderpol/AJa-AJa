package com.ajaaja.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ajaaja.rest.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long>{
	// { 'keyword' : keyword }
	Category findByKeyword(String keyword);
}
