package com.exercicio.mapper;

import com.exercicio.domain.Study;
import com.exercicio.dto.StudyUpdateRequest;
import com.exercicio.dto.StudySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330")
public interface StudyMapper {

     @Mapping(target = "id", source = "id")
     @Mapping(target = "name", source = "name")
     @Mapping(target = "email", source = "email")
     @Mapping(target = "team", source = "team")
     @Mapping(target = "address", source = "address")
     Study toDomain(StudyUpdateRequest studyUpdateRequest);

     @Mapping(target = "name", source = "name")
     @Mapping(target = "email", source = "email")
     @Mapping(target = "team", source = "team")
     @Mapping(target = "address", source = "address")
     Study toDomainSave(StudySaveRequest studySaveRequest);
}
