package com.gafur.app.test.piano.controller;

import com.gafur.app.test.piano.common.*;
import com.gafur.app.test.piano.service.SearchService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@RunWith(SpringRunner.class)
public class SearchControllerTest {
    private SearchController searchController;
    private MockMvc mockMvc;

    @Mock
    SearchService searchService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        searchController = new SearchController(searchService);
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }

    @Test
    public void testSearchByTitle() throws Exception {
        SearchRequest searchRequest = new SearchRequest("searchValue", new PageRequest(10, 30));
        SearchResponse searchResponse = generateSearchResponse(searchRequest);
        doReturn(searchResponse).when(searchService).search(eq(searchRequest));

        mockMvc.perform(get("/result")
                .param("inTitle", "searchValue")
                .param("page", "10")
                .param("size", "30")
        )
                .andExpect(status().isOk())
                .andExpect(model().attribute(
                        "searchResponse",
                        Matchers.hasProperty("inTitle",
                                Matchers.equalTo("searchValue"))))
                .andExpect(model().attribute(
                        "searchResponse",
                        Matchers.hasProperty("currentPage",
                                Matchers.equalTo(10))))
                .andExpect(model().attribute(
                        "searchResponse",
                        Matchers.hasProperty("hasMore",
                                Matchers.equalTo(true))))
                .andExpect(model().attribute(
                        "searchResponse",
                        Matchers.hasProperty("questions")));
    }

    private SearchResponse generateSearchResponse(SearchRequest searchRequest) {
        QuestionDto searchResult = new QuestionDto();
        searchResult.setTitle("questionTitle");
        searchResult.setUsername("username");
        searchResult.setDateOfQuestion(new Date());
        searchResult.setAlreadyAnswered(true);
        searchResult.setLink("link");

        SearchResponse response = new SearchResponse();
        response.setCurrentPage(searchRequest.getPageable().getPageNumber());
        response.setHasMore(true);
        response.setInTitle(searchRequest.getInTitle());
        response.setQuestions(asList(searchResult));
        return response;
    }
}
