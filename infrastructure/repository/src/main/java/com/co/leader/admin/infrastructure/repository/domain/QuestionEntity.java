package com.co.leader.admin.infrastructure.repository.domain;

import com.co.leader.commons.repository.domain.support.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "questions")
public class QuestionEntity extends Entities<Long> {

    @Column(name = "unique_id", nullable = false, length = 40)
    private String uniqueId;

    private String question;

    private String axis;
}
