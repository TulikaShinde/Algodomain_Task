package com.algodomain.entity;

import javax.persistence.*;

@Entity
@Table(name="products_algodomain")
public class Product {
	
	@Id
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_type")
	private String productType;
	
	// Foreign Key
	// * Product ---> 1 Category
	@ManyToOne
	@JoinColumn(name="product_category")
	private Category category ;
	
	@Column(name="product_price")
	private int productPrice;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String productType, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Category getProductCategory() {
		return category;
	}

	public void setProductCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}
