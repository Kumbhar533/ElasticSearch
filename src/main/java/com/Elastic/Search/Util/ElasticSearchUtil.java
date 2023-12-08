package com.Elastic.Search.Util;

import java.util.function.Supplier;

import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery.Builder;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Configuration
public class ElasticSearchUtil {
//this method always provides fresh queries 
	public static Supplier<Query> supplier() {
		Supplier<Query> supplier = () -> Query.of(q -> q.matchAll(matchAllQuery()));

		return supplier;
	}

	public static MatchAllQuery matchAllQuery() {

		Builder matchAllQuery = new MatchAllQuery.Builder();

		return matchAllQuery.build();
	}

	public static Supplier<Query> supplier1(String field) {
		Supplier<Query> supplier = () -> Query.of(q -> q.match(matchQuery(field)));

		return supplier;
	}

	public static MatchQuery matchQuery(String fieldName) {

		co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery.Builder matchQuery = new MatchQuery.Builder();

		return matchQuery.field("productName").query(fieldName).build();
	}

}
