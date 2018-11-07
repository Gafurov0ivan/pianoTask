package com.gafur.app.test.piano.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Pageable;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@Data
@AllArgsConstructor
public class SearchRequest {
    private String inTitle;
    private Pageable pageable;
}
