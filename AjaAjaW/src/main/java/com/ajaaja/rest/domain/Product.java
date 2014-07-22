package com.ajaaja.rest.domain;

import java.io.Serializable;

import com.mongodb.BasicDBObject;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8394046006898436941L;
	private String productCode;
	private String company;
	
	public Product(){};
	public Product(String productCode, String company) {
		this.productCode = productCode;
		this.company = company;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

	@Override
	public String toString(){
		return "{ productCode : "+productCode + ", company : " + company+" }";
	}
}
