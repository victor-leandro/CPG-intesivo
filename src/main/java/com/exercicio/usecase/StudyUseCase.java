package com.exercicio.usecase;

import com.exercicio.domain.Study;
import com.exercicio.dto.StudySaveRequest;
import com.exercicio.dto.StudyUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface StudyUseCase {

    Study save(StudySaveRequest study) throws Exception;

    List<Study> getAllStudy();

    Optional<Study> getStudy(Long id);

    Study replaceStudy(StudyUpdateRequest aluno) throws Exception;

    void deleteStudy(Long id);

    List<Study> findAllByName(String name);

}
