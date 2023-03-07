package com.algodomain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain.entity.Category;
import com.algodomain.entity.Product;
import com.algodomain.service.IProductService;

@RestController
@RequestMapping("/algodomain")
public class ProductController {
	
	//dependency : service
	@Autowired
	private IProductService prodService;
	
	public ProductController() {
		System.out.println("in ctor of "+getClass());
	}
	
	
	//get all product details in a list
	@GetMapping
	public ResponseEntity<?> showProductList() {
		System.out.println("controller showProductList() ");
		List<Product> list = prodService.getProductList();
		if(list.isEmpty())
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//add a new Product
	@PostMapping
	public ResponseEntity<Product> saveProductDetails(@RequestBody Product prod){
		System.out.println("controller saveProductDetails() ");
		System.out.println("Product : " + prod);
		return new ResponseEntity<Product>(prodService.saveProductDetails(prod), HttpStatus.CREATED);
	}
	
	//delete a Product by its Id
	@DeleteMapping("/{prodId}")
	public String deleteProduct(@PathVariable int prodId) {
		System.out.println("controller deleteProduct() ");
		return prodService.deleteProduct(prodId);
	}
	
	//update existing Product details 
	@PutMapping
	public Product updateProductDetails(@RequestBody Product prod) {
		System.out.println("controller updateProductDetails() ");
		return prodService.updateProductDetails(prod);
	}
	
	/*
	//get product details by id : creating ambiguous mapping for getProduct()
	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProductById(@PathVariable int prodId){
		return ResponseEntity.ok(prodService.getProdById(prodId));
	}
	*/
	
	//get final price of selected product : 
	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProduct(@PathVariable int prodId){
		return ResponseEntity.ok(prodService.getProduct(prodId));
	}
}
