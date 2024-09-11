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
@Table(name = "economic_sectors")
public class SectorEntity extends Entities<Long> {

    @Column(name = "sector_name", nullable = false)
    private String sectorName;

}
