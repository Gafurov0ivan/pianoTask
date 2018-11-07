package com.gafur.app.test.piano.service;

import com.gafur.app.test.piano.common.SearchRequest;
import com.gafur.app.test.piano.common.SearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@Service
public class StackExchangeServiceImpl implements StackExchangeClient {
    private final RestTemplate restTemplate;

    @Value("${stack.exchange.url}")
    private String STACK_EXCHANGE_ENDPOINT;
    @Value("${site.for.search}")
    private String SITE;

    public StackExchangeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SearchResponse searchByTitle(SearchRequest request) {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(STACK_EXCHANGE_ENDPOINT)
                .pathSegment("search")
                .queryParam("page", request.getPageable().getPageNumber())
                .queryParam("pagesize", request.getPageable().getPageSize())
                .queryParam("intitle", request.getInTitle())
                .queryParam("site", SITE);

        ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.build().toUri(),
                HttpMethod.GET,
                null,
                SearchResponse.class);

        return responseEntity.getBody();
    }
}
