package com.co.leader.admin.infrastructure.repository.domain;

import com.co.leader.commons.repository.domain.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "admin_users")
public class AdminEntity extends UserEntity<Long> {

    @Column(name = "unique_id", nullable = false, length = 40)
    private String uniqueId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "attempts")
    private Integer attempts;
}
