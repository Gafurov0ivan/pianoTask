package com.gafur.app.test.piano.common;

import lombok.Data;

import java.util.Date;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@Data
public class QuestionDto {
    private String title;
    private String username;
    private Date dateOfQuestion;
    private boolean isAlreadyAnswered;
    private String link;
}
