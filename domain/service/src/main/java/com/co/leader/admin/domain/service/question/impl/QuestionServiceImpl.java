package com.co.leader.admin.domain.service.question.impl;

import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return null;
    }

    @Override
    public QuestionDTO getQuestionByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    public Boolean existsByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    public void save(QuestionDTO question) {

    }

    @Override
    public QuestionDTO update(QuestionDTO question, String uniqueId) {
        return null;
    }

    @Override
    public void delete(String uniqueId) {

    }
}
