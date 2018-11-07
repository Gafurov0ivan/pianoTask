package com.gafur.app.test.piano.controller;

import com.gafur.app.test.piano.common.SearchRequest;
import com.gafur.app.test.piano.common.SearchResponse;
import com.gafur.app.test.piano.service.SearchService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author igafurov
 * @since 06.11.2018
 */
@Controller
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/")
    public String mainPage() {
        return "redirect:/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getSearch() {
        return new ModelAndView("search");
    }

    @RequestMapping(path = "/result", method = RequestMethod.GET)
    public ModelAndView searchByTitle(
            @RequestParam(value = "inTitle") String title,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        SearchResponse searchResponse = searchService.search(new SearchRequest(title, new PageRequest(page, size)));
        return new ModelAndView("results", "searchResponse", searchResponse);
    }
}

