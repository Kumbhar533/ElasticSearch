package com.Elastic.Search.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Elastic.Search.Entities.Product;
import com.Elastic.Search.Service.ElasticSearchService;
import com.Elastic.Search.Service.ProductService;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ElasticSearchService elasticSearchService;

	@GetMapping
	public ResponseEntity<?> getAll() {

		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			Product product1 = productService.addProduct(product);
			return ResponseEntity.ok(product1);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String id) {
		return ResponseEntity.ok(productService.updateProduct(product, id));
	}

	@DeleteMapping("/{id}")
	public void updateProduct(@PathVariable String id) {
		productService.deleteProduct(id);
		System.out.println("deleted");
	}

	@GetMapping("/matches")
	public ResponseEntity<?> getAllMatches() throws ElasticsearchException, IOException {
		SearchResponse<Map> searchResponse = elasticSearchService.searchResponse();
		System.err.println(searchResponse);
		return ResponseEntity.ok(searchResponse);
	}

	@GetMapping("/Allmatches")
	public List<Product> AllMatches() throws ElasticsearchException, IOException {
		SearchResponse<Product> searchResponse = elasticSearchService.MatchAll();

		List<Hit<Product>> hits = searchResponse.hits().hits();
		List<Product> products = new ArrayList<>();
		for (Hit<Product> hit : hits) {

			products.add(hit.source());

		}
		return products;

	}

	@GetMapping("/Allmatches/{field}")
	public List<Product> matchField(@PathVariable String field) throws ElasticsearchException, IOException {
		SearchResponse<Product> searchResponse = elasticSearchService.MatchFiled(field);

		List<Hit<Product>> hits = searchResponse.hits().hits();
		List<Product> products = new ArrayList<>();
		for (Hit<Product> hit : hits) {

			products.add(hit.source());

		}
		return products;

	}
}
