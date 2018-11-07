package com.gafur.app.test.piano.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.gafur.app.test.piano.common.QuestionDto;
import com.gafur.app.test.piano.common.SearchResponse;

import java.io.IOException;
import java.util.*;

/**
 * @author igafurov
 * @since 06.11.2018
 */
public class SearchResponseDeserializer extends StdDeserializer<SearchResponse> {

    public static final String HAS_MORE = "has_more";
    public static final String ITEMS = "items";

    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String OWNER = "owner";
    public static final String DISPLAY_NAME = "display_name";
    public static final String CREATION_DATE = "creation_date";
    public static final String IS_ANSWERED = "is_answered";

    public SearchResponseDeserializer() {
        this(null);
    }

    public SearchResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SearchResponse deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        SearchResponse response = new SearchResponse();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        response.setHasMore(node.get(HAS_MORE).asBoolean());

        List<QuestionDto> questions = new ArrayList<>();
        for (final JsonNode questionElement : node.get(ITEMS)) {
            QuestionDto question = new QuestionDto();
            question.setTitle(questionElement.get(TITLE).asText());
            question.setAlreadyAnswered(questionElement.get(IS_ANSWERED).asBoolean());
            question.setUsername(questionElement.get(OWNER).get(DISPLAY_NAME).asText());
            question.setDateOfQuestion(new Date(questionElement.get(CREATION_DATE).asInt()));
            question.setLink(questionElement.get(LINK).asText());
            questions.add(question);
        }

        response.setQuestions(questions);
        return response;
    }
}
