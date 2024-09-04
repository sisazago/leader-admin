package com.co.leader.admin.infrastructure.adapter.repository.question;

import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.repository.QuestionRepository;
import com.co.leader.admin.infrastructure.repository.QuestionJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionAdapterRepository implements QuestionRepository {

    private final QuestionJpaRepository repository;

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
