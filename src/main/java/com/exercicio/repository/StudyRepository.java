package com.exercicio.repository;

import com.exercicio.domain.Study;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {

    Optional<Study> findByCpfContainsOrEmailContains(String cpf, String email);

    List<Study> findByNameContains(String name);

}
