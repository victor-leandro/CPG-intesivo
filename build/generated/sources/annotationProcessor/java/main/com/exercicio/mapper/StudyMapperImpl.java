package com.exercicio.mapper;

import com.exercicio.domain.Study;
import com.exercicio.dto.StudySaveRequest;
import com.exercicio.dto.StudyUpdateRequest;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T17:01:08-0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Singleton
@Named
public class StudyMapperImpl implements StudyMapper {

    @Override
    public Study toDomain(StudyUpdateRequest studyUpdateRequest) {
        if ( studyUpdateRequest == null ) {
            return null;
        }

        Study.StudyBuilder study = Study.builder();

        study.id( studyUpdateRequest.getId() );
        study.name( studyUpdateRequest.getName() );
        study.email( studyUpdateRequest.getEmail() );
        study.team( studyUpdateRequest.getTeam() );
        study.address( studyUpdateRequest.getAddress() );
        study.birthDate( studyUpdateRequest.getBirthDate() );
        study.cpf( studyUpdateRequest.getCpf() );

        return study.build();
    }

    @Override
    public Study toDomainSave(StudySaveRequest studySaveRequest) {
        if ( studySaveRequest == null ) {
            return null;
        }

        Study.StudyBuilder study = Study.builder();

        study.name( studySaveRequest.getName() );
        study.email( studySaveRequest.getEmail() );
        study.team( studySaveRequest.getTeam() );
        study.address( studySaveRequest.getAddress() );
        study.birthDate( studySaveRequest.getBirthDate() );
        study.cpf( studySaveRequest.getCpf() );

        return study.build();
    }
}
