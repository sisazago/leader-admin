package com.co.leader.admin.infrastructure.boot.app.mock;

import com.co.leader.admin.application.question.model.response.QuestionResponse;
import com.co.leader.admin.domain.model.QuestionDTO;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.UUID;

public class QuestionMockObjects {

    public static QuestionDTO getQuestionDTO(){
        return QuestionDTO.builder()
                .axis("X")
                .question("Test Question")
                .uniqueId(UUID.randomUUID().toString())
                .build();
    }

    public static List<QuestionDTO> getQuestionList(){
        List<QuestionDTO> questions = Lists.newArrayList();
        questions.add(getQuestionDTO());
        return questions;
    }

    public static QuestionResponse getQuestionResponse(){
        return QuestionResponse.builder()
                .axis("X")
                .question("Test Question")
                .uniqueId(UUID.randomUUID().toString())
                .build();
    }

    public static List<QuestionResponse> gQuestionResponses(){
        List<QuestionResponse> questions =  Lists.newArrayList();
        questions.add(getQuestionResponse());
        return questions;
    }
}
