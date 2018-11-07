package com.gafur.app.test.piano.service;

import com.gafur.app.test.piano.common.SearchRequest;
import com.gafur.app.test.piano.common.SearchResponse;

/**
 * @author igafurov
 * @since 06.11.2018
 */
public interface StackExchangeClient {

    /**
     * Search info in Stack Exchange by request
     *
     * @param request
     * @return response with items
     */
    SearchResponse searchByTitle(SearchRequest request);
}
