package com.algodomain.tests;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.algodomain.entity.Product;
import com.algodomain.controller.ProductController;
import com.algodomain.service.ProductService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

	@Autowired
	private ProductController productController;

	@MockBean
	private ProductService productService;

	@Test
	public void getUsers_ReturnsListOfUsers() {
		List<Product> expectedUsers = Arrays.asList(new Product(5, "LG Fridge", "Refrigerator", 30000),
				new Product(10, "Samsung", "Microwave Oven", 15000));
		Mockito.when(productService.getProductList()).thenReturn(expectedUsers);

		List<Product> actualUsers = (List<Product>) productController.showProductList();

		Assert.assertEquals(expectedUsers, actualUsers);
	}
}
