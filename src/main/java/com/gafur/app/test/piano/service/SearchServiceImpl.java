package com.gafur.app.test.piano.service;

import com.gafur.app.test.piano.common.SearchRequest;
import com.gafur.app.test.piano.common.SearchResponse;
import org.springframework.stereotype.Service;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@Service
public class SearchServiceImpl implements SearchService {
    private StackExchangeClient stackExchangeClient;

    public SearchServiceImpl(StackExchangeClient stackExchangeClient) {
        this.stackExchangeClient = stackExchangeClient;
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        SearchResponse response = stackExchangeClient.searchByTitle(searchRequest);

        response.setInTitle(searchRequest.getInTitle());
        response.setCurrentPage(searchRequest.getPageable().getPageNumber());

        return response;
    }
}
