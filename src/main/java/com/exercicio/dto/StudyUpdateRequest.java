package com.exercicio.dto;

import com.exercicio.domain.Address;
import com.exercicio.domain.Team;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Introspected
public class StudyUpdateRequest {

    @NotNull(message = "O id do aluno é obrigatório.")
    private Long id;
    private String name;
    private String email;
    private Team team;
    private String birthDate;
    private String cpf;
    private Address address;
}
