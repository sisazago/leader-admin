package com.co.leader.admin.infrastructure.boot.app;

import com.co.leader.admin.application.question.model.mapper.QuestionControllerMapper;
import com.co.leader.admin.application.question.rest.impl.QuestionRestControllerImpl;
import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.service.question.QuestionService;
import com.co.leader.admin.infrastructure.boot.app.mock.QuestionMockObjects;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(QuestionRestControllerImpl.class)
class QuestionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionControllerMapper mapper;

    @Test
    @WithMockUser(roles = "ADMIN")
    void testGetQuestions() throws Exception {
        given(questionService.getAllQuestions()).willReturn(QuestionMockObjects.getQuestionList());
        given(mapper.toQuestionsList(anyList())).willReturn(QuestionMockObjects.gQuestionResponses());

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

        System.out.println(response);
    }

}
