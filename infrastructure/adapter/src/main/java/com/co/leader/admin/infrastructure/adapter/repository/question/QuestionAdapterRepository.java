package com.co.leader.admin.infrastructure.adapter.repository.question;

import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.domain.repository.QuestionRepository;
import com.co.leader.admin.infrastructure.adapter.repository.question.mapper.QuestionAdapterMapper;
import com.co.leader.admin.infrastructure.repository.QuestionJpaRepository;
import com.co.leader.admin.infrastructure.repository.domain.QuestionEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionAdapterRepository implements QuestionRepository {

    private final QuestionJpaRepository repository;

    private final QuestionAdapterMapper mapper;

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<QuestionEntity> entities = repository.findAll();
        return mapper.toDTOS(entities);
    }

    @Override
    public QuestionDTO getQuestionByUniqueId(String uniqueId) {
        Optional<QuestionEntity> entity = repository.findByUniqueId(uniqueId);
        AtomicReference<QuestionDTO> result = new AtomicReference<>();
        entity.ifPresent(value -> result.set(mapper.toDTO(value)));
        return result.get();
    }

    @Override
    public Boolean existsByUniqueId(String uniqueId) {
        Optional<QuestionEntity> entity = repository.findByUniqueId(uniqueId);
        return entity.isPresent();
    }

    @Override
    public void save(QuestionDTO question) {
        QuestionEntity entity = mapper.toEntity(question);

        repository.save(entity);
    }

    @Override
    public QuestionDTO update(QuestionDTO question, String uniqueId) {
        Optional<QuestionEntity> entity = repository.findByUniqueId(uniqueId);

        entity.ifPresent(value -> {
            value.setQuestion(question.getQuestion());
            value.setAxis(question.getAxis());

            repository.save(value);
        });
        return mapper.toDTO(entity.get());
    }

    @Override
    public void delete(String uniqueId) {
        Optional<QuestionEntity> entity = repository.findByUniqueId(uniqueId);
        
        entity.ifPresent(repository::delete);
    }
}
