package com.co.leader.admin.application.question.model.mapper;

import com.co.leader.admin.application.question.model.request.QuestionRequest;
import com.co.leader.admin.application.question.model.response.QuestionResponse;
import com.co.leader.admin.domain.model.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionControllerMapper {

    QuestionResponse toQuestionResponse(QuestionDTO questionDTO);

    List<QuestionResponse> toQuestionsList(List<QuestionDTO> questionDTOS);

    QuestionDTO toDto(QuestionRequest question);
}
