package com.exercicio.usecase;

import com.exercicio.domain.Address;
import com.exercicio.domain.City;
import com.exercicio.domain.Study;
import com.exercicio.domain.Team;
import com.exercicio.dto.StudySaveRequest;
import com.exercicio.dto.StudyUpdateRequest;
import com.exercicio.repository.StudyRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@MicronautTest
public class StudyUseCaseTest {

    @Inject
    private StudyUseCase studyUseCase;


    @Test
    public void validationSave() throws Exception {
        StudySaveRequest study = StudySaveRequest.builder().email("flamengo@outlook.com")
                .birthDate("22/08/1996")
                .name("flamengo")
                .cpf("97744194055")
                .team(Team.builder().typeClass("Boxe").build())
                .address(Address.builder().cep("08654334").codeIBGE(3301L)
                        .complement("Bairro")
                        .district("Vila sonia")
                        .number("233")
                        .city(City.builder().state("RJ").name("Rio de janeiro").build())
                        .build()).build();

//        Mockito.when(studyRepository.save(Mockito.any())).thenReturn(study);

        Study save = studyUseCase.save(study);

        Assertions.assertEquals("97744194055", save.getCpf());
    }


//    @Test
//    public void validationUpdate() throws Exception {
//        StudyUpdateRequest study = StudyUpdateRequest.builder().email("flamengo@outlook.com")
//                .id(28L)
//                .birthDate("27/03/1985")
//                .name("São paulo")
//                .cpf("97744194055")
//                .team(Team.builder().typeClass("king box").build())
//                .address(Address.builder().cep("08654334").codeIBGE(3301L)
//                        .complement("Bairro")
//                        .district("Vila pereta")
//                        .number("76")
//                        .city(City.builder().state("RJ").name("Rio de janeiro").build())
//                        .build()).build();
//
//
//        Study save = studyUseCase.replaceStudy(study);
//
//        Assertions.assertEquals("97744194055", save.getCpf());
//        Assertions.assertEquals("São paulo", save.getName());
//    }

}
