package com.Elastic.Search.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Elastic.Search.Entities.Product;
import com.Elastic.Search.Reposistories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> getAllProducts() {

		ArrayList<Product> list = new ArrayList<Product>();
		Iterable<Product> findAll = productRepo.findAll();

		findAll.forEach(list::add);

		return list;
	}

	public Product addProduct(Product product) {

		return productRepo.save(product);

	}

	public Product updateProduct(Product product, String id) {

		Product p = productRepo.findById(id).get();
		p.setId(id);
		p.setProductName(product.getProductName());
		p.setExpiryDate(product.getExpiryDate());
		p.setPrice(product.getPrice());

		return productRepo.save(p);

	}

	public void deleteProduct(String id) {
		productRepo.deleteById(id);
	}
}
