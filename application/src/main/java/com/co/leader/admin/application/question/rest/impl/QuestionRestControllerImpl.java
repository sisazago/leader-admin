package com.co.leader.admin.application.question.rest.impl;

import com.co.leader.admin.application.question.model.mapper.QuestionControllerMapper;
import com.co.leader.admin.application.question.model.request.QuestionRequest;
import com.co.leader.admin.application.question.model.response.QuestionResponse;
import com.co.leader.admin.application.question.rest.QuestionRestController;
import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.service.question.QuestionService;
import com.co.leader.commons.web.rest.handler.RestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionRestControllerImpl implements QuestionRestController {

    private final QuestionService questionService;

    private final QuestionControllerMapper mapper;

    @Override
    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAllQuestions() {
        List<QuestionDTO> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(mapper.toQuestionsList(questions));
    }

    @Override
    @GetMapping("/{unique-id}")
    public ResponseEntity<QuestionResponse> getQuestionByUniqueId(@PathVariable("unique-id") String uniqueId) {
        QuestionDTO result = questionService.getQuestionByUniqueId(uniqueId);
        return ResponseEntity.ok(mapper.toQuestionResponse(result));
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody QuestionRequest questionRequest, BindingResult result) {
        if (!result.hasErrors()) {
            questionService.save(mapper.toDto(questionRequest));
            return ResponseEntity.accepted().build();
        }
        throw new RestException("The information is not complete", HttpStatus.UNPROCESSABLE_ENTITY, "10006", result.getAllErrors());
    }

    @Override
    @PutMapping("/{unique-id}")
    public ResponseEntity<QuestionResponse> update(@RequestBody QuestionRequest question, @PathVariable("unique-id") String uniqueId, BindingResult result) {
        if (!result.hasErrors()) {
            if (questionService.existsByUniqueId(uniqueId)){
                questionService.update(mapper.toDto(question), uniqueId);
                return  ResponseEntity.accepted().build();
            }
            throw new RestException("The question does not exists", HttpStatus.CONFLICT, "10005");
        }
        throw new RestException("The information is not complete", HttpStatus.UNPROCESSABLE_ENTITY, "10006", result.getAllErrors());
    }

    @Override
    @DeleteMapping("/{unique-id}")
    public ResponseEntity<Void> delete(@PathVariable("unique-id") String uniqueId) {
        if (questionService.existsByUniqueId(uniqueId)){
            questionService.delete(uniqueId);
            return  ResponseEntity.accepted().build();
        }
        throw new RestException("The question does not exists", HttpStatus.CONFLICT, "10005");
    }
}
