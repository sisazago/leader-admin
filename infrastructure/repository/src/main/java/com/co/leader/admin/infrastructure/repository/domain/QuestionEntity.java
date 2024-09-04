package com.co.leader.admin.infrastructure.repository.domain;

import com.co.leader.commons.repository.domain.support.Entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
