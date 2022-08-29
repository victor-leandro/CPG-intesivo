package com.exercicio.usecase.impl;

import br.com.caelum.stella.validation.CPFValidator;
import com.exercicio.client.IBGEClient;
import com.exercicio.client.model.IBGEResult;
import com.exercicio.domain.Study;
import com.exercicio.dto.StudySaveRequest;
import com.exercicio.dto.StudyUpdateRequest;
import com.exercicio.exception.MenorIdadeExeption;
import com.exercicio.mapper.StudyMapper;
import com.exercicio.repository.StudyRepository;
import com.exercicio.usecase.StudyUseCase;
import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class StudyUseCaseImpl implements StudyUseCase {
    @Inject
    private StudyRepository studyRepository;
    @Inject
    private IBGEClient ibgeClient;
    @Inject
    private StudyMapper studyMapper;

    @Override
    public Study save(StudySaveRequest study) throws Exception {
        LocalDate date = getLocalDate(study.getBirthDate());
        Period period = Period.between(date, LocalDate.now());
        validationIBGE(study.getAddress().getCodeIBGE());

        if (period.getYears() < 18) {
            throw new MenorIdadeExeption("Sua idade é menor que 18.");
        } else if (!valida(study.getCpf())) {
            throw new MenorIdadeExeption("CPF inválido.");
        }
        studyRepository.findByCpfContainsOrEmailContains(study.getCpf(), study.getEmail()).
                ifPresent(study1 -> {
                    try {
                        throw new Exception("CPF ou Email ja existentes.");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        Study response = studyMapper.toDomainSave(study);
        return studyRepository.save(response);
    }

    @Override
    public List<Study> getAllStudy() {
        return studyRepository.findAll();
    }

    @Override
    public Optional<Study> getStudy(Long id) {
        return studyRepository.findById(id);
    }

    @Override
    public Study replaceStudy(StudyUpdateRequest study) throws Exception {
        Study studyResponse = studyMapper.toDomain(study);
        Optional<Study> byId = studyRepository.findById(studyResponse.getId());
        if (!byId.isPresent()){
            throw new Exception("Estudante ja existente.");
        }
        return studyRepository.update(studyResponse);
    }

    @Override
    public void deleteStudy(Long id) {
        studyRepository.deleteById(id);
    }

    @Override
    public List<Study> findAllByName(String name) {
        return studyRepository.findByNameContains(name);
    }

    private void validationIBGE(Long id) throws Exception {
        HttpResponse<List<IBGEResult>> ibgeCode = ibgeClient.getIBGECode(id);
       if (ibgeCode.getBody().get().isEmpty()){
           throw new Exception("Codigo IBGE invalido.");
       }
    }

    private static LocalDate getLocalDate(String source) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parse = LocalDate.parse(source, formato);
        return parse;
    }

    public static boolean valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
