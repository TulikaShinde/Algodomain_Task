package com.algodomain.entity;

import javax.persistence.*;

@Entity
@Table(name="category_algodomain")
public class Category {
	@Id
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="gst")
	private int gst;
	
	@Column(name="delivery_charge")
	private int delivery;

	public Category() {
		super();
	}

	public Category(String productCategory, int discount, int gst, int delivery) {
		super();
		this.productCategory = productCategory;
		this.discount = discount;
		this.gst = gst;
		this.delivery = delivery;
	}
	
	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
}
