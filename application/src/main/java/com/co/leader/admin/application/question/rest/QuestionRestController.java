package com.co.leader.admin.application.question.rest;

import com.co.leader.admin.application.question.model.request.QuestionRequest;
import com.co.leader.admin.application.question.model.response.QuestionResponse;
import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.commons.web.rest.handler.support.ApiError;
import com.co.leader.commons.web.rest.support.AbstractRestSupportController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

@Api(tags = "Questions API")
public interface QuestionRestController extends AbstractRestSupportController {

    @ApiOperation(value = "Get The list of all the questions available")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get The list of all the questions available"),
            @ApiResponse(code = 500, response = ApiError.class, message = "Internal server error")
    })
    ResponseEntity<List<QuestionResponse>> getAllQuestions();

    @ApiOperation(value = "Get Question By unique Identifier")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Created Question success"),
            @ApiResponse(code = 409, response = ApiError.class, message = "The unique identifier does not exists"),
            @ApiResponse(code = 500, response = ApiError.class, message = "Internal server error")
    })
    ResponseEntity<QuestionResponse> getQuestionByUniqueId(String uniqueId);

    @ApiOperation(value = "Create new Question")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created Question success"),
            @ApiResponse(code = 409, response = ApiError.class, message = "The question already exists"),
            @ApiResponse(code = 422, response = ApiError.class, message = "The information is not complete"),
            @ApiResponse(code = 500, response = ApiError.class, message = "Internal server error")
    })
    ResponseEntity<Void> save(QuestionRequest questionRequest, BindingResult result);

    @ApiOperation(value = "Update a question")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Update Question success"),
            @ApiResponse(code = 409, response = ApiError.class, message = "The question already exists"),
            @ApiResponse(code = 422, response = ApiError.class, message = "The information is not complete"),
            @ApiResponse(code = 500, response = ApiError.class, message = "Internal server error")
    })
    ResponseEntity<QuestionResponse> update(QuestionRequest question, String uniqueId, BindingResult result);

    @ApiOperation(value = "Delete a question")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Delete Question success"),
            @ApiResponse(code = 409, response = ApiError.class, message = "The unique identifier does not exists"),
            @ApiResponse(code = 500, response = ApiError.class, message = "Internal server error")
    })
    ResponseEntity<Void> delete(String uniqueId);
}
