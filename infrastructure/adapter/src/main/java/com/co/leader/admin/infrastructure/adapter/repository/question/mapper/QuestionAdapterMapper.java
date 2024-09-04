package com.co.leader.admin.infrastructure.adapter.repository.question.mapper;

import com.co.leader.admin.domain.model.QuestionDTO;
import com.co.leader.admin.infrastructure.repository.domain.QuestionEntity;
import com.co.leader.commons.dto.jpa.support.JpaMapperConfig;
import com.co.leader.commons.dto.jpa.support.PageJpaMapper;
import com.co.leader.commons.dto.pagination.PageResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", config = JpaMapperConfig.class)
public interface QuestionAdapterMapper extends PageJpaMapper<QuestionDTO, QuestionEntity> {

    @Override
    QuestionEntity toEntity(QuestionDTO question);

    @Override
    QuestionEntity toEntity(QuestionDTO question, @MappingTarget QuestionEntity questionEntity);

    @Override
    QuestionDTO toDTO(QuestionEntity questionEntity);

    @Override
    List<QuestionDTO> toDTOS(List<QuestionEntity> list);

    default PageResultDTO<String> paginationStringResult(Page<String> tags) {
        PageResultDTO result = new PageResultDTO();
        result.setData(tags.getContent());
        result.setTotalRows(tags.getTotalElements());
        result.setPageSize(tags.getSize());
        result.setPageNumber(tags.getNumber());
        return result;
    }
}
