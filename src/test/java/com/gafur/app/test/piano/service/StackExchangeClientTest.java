package com.gafur.app.test.piano.service;

import com.gafur.app.test.piano.common.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackExchangeClientTest {
    @Autowired
    private StackExchangeClient stackExchangeClient;

    @Test
    public void testSearchByTitle() {
        Integer currentPage = 1;
        Integer size = 10;
        SearchRequest searchRequest = new SearchRequest("java", new PageRequest(currentPage, size));

        SearchResponse response = stackExchangeClient.searchByTitle(searchRequest);
        assertNotNull(response);
        assertEquals(true, response.getHasMore());
        assertTrue(response.getQuestions().size() > 0);

        QuestionDto question = response.getQuestions().get(0);
        assertNotNull(question.getTitle());
        assertNotNull(question.getDateOfQuestion());
        assertNotNull(question.getUsername());
        assertNotNull(question.getLink());
    }
}
