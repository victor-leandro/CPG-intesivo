package com.exercicio.controller;

import com.exercicio.domain.Study;
import com.exercicio.dto.StudySaveRequest;
import com.exercicio.dto.StudyUpdateRequest;
import com.exercicio.usecase.StudyUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Controller("/api/study")
@Validated
public class StudyController {

    @Inject
    private StudyUseCase studyUseCase;

    @Post
    public HttpResponse<Study> saveStudy(@Body @Valid StudySaveRequest study) throws Exception {
        return HttpResponse.created(studyUseCase.save(study));
    }

    @Get
    public List<Study> getAllStudy() {
        return studyUseCase.getAllStudy();
    }


    @Get("/name/{name}")
    public List<Study> getAllStudyByName(String name) {
        return studyUseCase.findAllByName(name);
    }


    @Get("/{id}")
    public HttpResponse<Study> getStudy(@PathVariable Long id) {
        return HttpResponse.ok(studyUseCase.getStudy(id).get());
    }

    @Put
    public HttpResponse<Study> replaceStudy(@Body @Valid StudyUpdateRequest study) throws Exception {
        return HttpResponse.ok(studyUseCase.replaceStudy(study));
    }

    @Delete("/{id}")
    public void deleteStudy(@PathVariable Long id) {
        studyUseCase.deleteStudy(id);
    }
}
