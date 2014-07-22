package com.ajaaja.rest.domain;


import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="category")
public class Category{
	@Id
	private String id;
	
	private String keyword;
	private List<Product> result;

	public Category(){};
	public Category(String keyword, List<Product> result){
		this.keyword = keyword;
		this.result = result;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Product> getResult() {
		return result;
	}
	public void setResult(List<Product> result) {
		this.result = result;
	}
	
	@Override
	public String toString(){
		return "{ keyword : "+keyword+", result : "+ result.toString()+" }";
	}
}
