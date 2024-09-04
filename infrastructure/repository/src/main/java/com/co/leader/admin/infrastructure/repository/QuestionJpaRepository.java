package com.co.leader.admin.infrastructure.repository;

import com.co.leader.admin.infrastructure.repository.domain.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {
}
