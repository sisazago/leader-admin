package com.co.leader.admin.domain.repository;

import com.co.leader.admin.domain.model.QuestionDTO;

import java.util.List;

public interface QuestionRepository {

    List<QuestionDTO> getAllQuestions();

    QuestionDTO getQuestionByUniqueId(String uniqueId);

    Boolean existsByUniqueId(String uniqueId);

    void save(QuestionDTO question);

    QuestionDTO update(QuestionDTO question, String uniqueId);

    void delete(String uniqueId);
}
