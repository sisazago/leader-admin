package com.co.leader.admin.domain.service.question.impl;

import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.repository.QuestionRepository;
import com.co.leader.admin.domain.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return repository.getAllQuestions();
    }

    @Override
    public QuestionDTO getQuestionByUniqueId(String uniqueId) {
        return repository.getQuestionByUniqueId(uniqueId);
    }

    @Override
    public Boolean existsByUniqueId(String uniqueId) {
        return repository.existsByUniqueId(uniqueId);
    }

    @Override
    public void save(QuestionDTO question) {
        String uuid = UUID.randomUUID().toString();
        if (!repository.existsByUniqueId(uuid)){
            question.setUniqueId(uuid);
            repository.save(question);
        }
    }

    @Override
    public QuestionDTO update(QuestionDTO question, String uniqueId) {
        return repository.update(question, uniqueId);
    }

    @Override
    public void delete(String uniqueId) {
        repository.delete(uniqueId);
    }
}
