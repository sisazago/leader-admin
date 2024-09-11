package com.co.leader.admin.infrastructure.repository;

import com.co.leader.admin.infrastructure.repository.domain.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminJpaRepository extends JpaRepository<AdminEntity, Long> {

    Optional<AdminEntity> findByUniqueIdEquals(String uniqueId);

    Optional<AdminEntity> findByUsernameEquals(String userName);
}
