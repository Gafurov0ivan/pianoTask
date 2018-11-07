package com.gafur.app.test.piano.service;

import com.gafur.app.test.piano.common.SearchRequest;
import com.gafur.app.test.piano.common.SearchResponse;

/**
 * @author igafurov
 * @since 06.11.2018
 */
public interface SearchService {

    /**
     * Search by request
     *
     * @param searchRequest
     * @return response with items and pageable
     */
    SearchResponse search(SearchRequest searchRequest);
}
