package com.Elastic.Search.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Elastic.Search.Util.ElasticSearchUtil;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;

@Service
public class ElasticSearchService {

	@Autowired
	private ElasticSearchUtil elasticSearchUtil;

	@Autowired
	private ElasticsearchClient elasticsearchClient;

	public SearchResponse<Map> searchResponse() throws ElasticsearchException, IOException {
		Supplier<Query> supplier = elasticSearchUtil.supplier();

		SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);

		return searchResponse;
	}

}
