package com.gafur.app.test.piano.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@Data
public class SearchResponse {
    private String inTitle;
    private Integer currentPage;
    private Boolean hasMore;
    private List<QuestionDto> questions = new ArrayList<>();
}
