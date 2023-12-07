package com.Elastic.Search.Reposistories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.Elastic.Search.Entities.Product;

public interface ProductRepo extends ElasticsearchRepository<Product, String> {

}
