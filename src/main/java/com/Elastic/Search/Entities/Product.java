package com.Elastic.Search.Entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@Id
	private String id;

	private String productName;

	private Date expiryDate;

	private Double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product(String id, String productName, Date expiryDate, Double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.expiryDate = expiryDate;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
