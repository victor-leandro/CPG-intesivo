package com.exercicio.dto;

import com.exercicio.domain.Address;
import com.exercicio.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudySaveRequest {
    private String name;
    @Email(message = "Email inválido.")
    private String email;
    private Team team;
    private String birthDate;
    private String cpf;
    private Address address;
}
