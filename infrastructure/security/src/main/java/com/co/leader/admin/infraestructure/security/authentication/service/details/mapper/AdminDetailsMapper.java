package com.co.leader.admin.infraestructure.security.authentication.service.details.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.core.GrantedAuthority;
import com.co.leader.admin.infraestructure.security.authentication.service.details.AdminDetails;
import com.co.leader.admin.infrastructure.repository.domain.AdminEntity;

import java.util.Collection;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminDetailsMapper {

    @Mappings({
            @Mapping(target = "authorities", source = "authorities")
    })
    AdminDetails toAdminDetails(AdminEntity entrepreneurEntity, Collection<GrantedAuthority> authorities);
}
