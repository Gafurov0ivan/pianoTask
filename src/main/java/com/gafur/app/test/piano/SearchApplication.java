package com.gafur.app.test.piano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author igafurov
 * @since 06.11.2018
 */
@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class SearchApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SearchApplication.class);
    }
}
