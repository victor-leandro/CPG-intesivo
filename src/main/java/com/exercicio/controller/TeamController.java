package com.exercicio.controller;

import com.exercicio.domain.Team;
import com.exercicio.repository.TeamRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/api/team")
public class TeamController {

    @Inject
    private TeamRepository teamRepository;

    @Get
    public HttpResponse<List<Team>> findAll(){
        return HttpResponse.ok(teamRepository.findAll());
    }

    @Get("/{id}")
    public HttpResponse<Team> findByTeam(@PathVariable Long id){
        return HttpResponse.ok(teamRepository.findById(id).get());
    }

    @Post
    public HttpResponse<Team> saveTeam(@Body Team team){
        return HttpResponse.ok(teamRepository.save(team));
    }

}
