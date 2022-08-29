package com.exercicio.repository;

import com.exercicio.domain.Team;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
