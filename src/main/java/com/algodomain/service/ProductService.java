package com.algodomain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.algodomain.entity.Category;
import com.algodomain.entity.Product;
import com.algodomain.entity.ProductDTO;
import com.algodomain.repository.CategoryRepository;
import com.algodomain.repository.ProductRepository;
import com.algodomain.custom_exceptions.ResourceNotFound;

@Service
@Transactional
public class ProductService implements IProductService {

	// dependency : Repository
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public List<Product> getProductList() {
		return prodRepo.findAll();
	}

	@Override
	public Product saveProductDetails(Product transientProd) {
		return prodRepo.save(transientProd);
	}

	@Override
	public String deleteProduct(int prodId) {
		String message = "Deletion failed";
		if (prodRepo.existsById(prodId)) {
			prodRepo.deleteById(prodId);
			message = "Product details deleted for prodId : " + prodId;
		}
		return message;
	}

	@Override
	public Product updateProductDetails(Product updateDetachedProd) {
		return prodRepo.save(updateDetachedProd);
	}

	@Override
	public Product getProdById(int prodId) {
		return prodRepo.findById(prodId).orElseThrow(() -> new ResourceNotFound("Invalid Product Id"));

	}

	// calculate final price of Product
	@Override
	public ProductDTO getProduct(int prodId) {
		Product getProd = getProdById(prodId);
		long price = getProd.getProductPrice();
		int id = getProd.getProductId();

		Category getCat = getProd.getProductCategory();
		long finalPrice = 0;

		if (getCat.getProductCategory().equals(getProd.getCategory().getProductCategory())) {
			int discount = getCat.getDiscount();
			int gst = getCat.getGst();
			int delivery = getCat.getDelivery();
			System.out.println(gst + delivery);
			
			// finalPrice = price+delivery+gst%-discount%
			finalPrice = price + delivery + (gst - discount) * (price / 100);
		}

		ProductDTO sendProdDto = new ProductDTO(String.valueOf(id), getProd.getProductName(),
				getProd.getProductType(), getCat.getProductCategory(), getProd.getProductPrice(), 
				getCat.getDiscount(), finalPrice, getCat.getGst(), getCat.getDelivery());
		return sendProdDto;
	}
}
