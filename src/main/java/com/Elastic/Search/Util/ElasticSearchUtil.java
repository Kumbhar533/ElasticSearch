package com.Elastic.Search.Util;

import java.util.function.Supplier;

import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery.Builder;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Configuration
public class ElasticSearchUtil {

	public static Supplier<Query> supplier() {
		Supplier<Query> supplier = () -> Query.of(q -> q.matchAll(matchAllQuery()));

		return supplier;
	}

	public static MatchAllQuery matchAllQuery() {

		Builder matchAllQuery = new MatchAllQuery.Builder();

		return matchAllQuery.build();
	}

}
