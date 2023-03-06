package com.backend.market.persistence.mapper;

import com.backend.market.domain.dto.CategoryDto;
import com.backend.market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mapping(source = "idCategory", target = "idCategoryDomain")
  @Mapping(source = "description", target = "category")
  @Mapping(source = "state", target = "active")
  CategoryDto toCategory(CategoryEntity categoryEntity);

  @InheritInverseConfiguration
  @Mapping(target = "productEntities", ignore = true)
  CategoryEntity toCategoryEntity(CategoryDto categoryDto);
}
