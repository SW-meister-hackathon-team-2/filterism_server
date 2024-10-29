package com.group2.filterism.filter.domain;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
interface FilterDomainMapper {
    FilterEntity toEntity(FilterDomainDto dto);
    FilterDomainDto toDto(FilterEntity entity);
}
