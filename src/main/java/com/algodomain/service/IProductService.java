package com.algodomain.service;

import java.util.List;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductDTO;

public interface IProductService {
	
	//get List of Products
	List<Product> getProductList();
	
	//add Product
	Product saveProductDetails(Product transientProd);
	
	//delete a Product
	String deleteProduct(int prodId);
	
	//update Product info
	Product updateProductDetails(Product updateDetachedProd);
	
	//get Prod details by prodId
	Product getProdById(int prodId);
	
	//getProducts method will calculate the final price of 
	//each product based on discount and other charges table
	ProductDTO getProduct(int prodId);
}
