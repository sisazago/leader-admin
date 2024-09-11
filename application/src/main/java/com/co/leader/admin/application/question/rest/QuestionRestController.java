package com.co.leader.admin.application.question.rest;

import com.co.leader.admin.application.question.model.request.QuestionRequest;
import com.co.leader.admin.application.question.model.response.QuestionResponse;
import com.co.leader.commons.web.rest.support.AbstractRestSupportController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface QuestionRestController extends AbstractRestSupportController {

    ResponseEntity<List<QuestionResponse>> getAllQuestions();

    ResponseEntity<QuestionResponse> getQuestionByUniqueId(String uniqueId);

    ResponseEntity<Void> save(QuestionRequest questionRequest, BindingResult result);

    ResponseEntity<QuestionResponse> update(QuestionRequest question, String uniqueId, BindingResult result);

    ResponseEntity<Void> delete(String uniqueId);
}
