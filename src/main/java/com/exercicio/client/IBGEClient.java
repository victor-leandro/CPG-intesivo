package com.exercicio.client;

import com.exercicio.client.model.IBGEResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("https://servicodados.ibge.gov.br/api/v1/")
public interface IBGEClient {
        @Get("/localidades/mesorregioes/{id}")
        HttpResponse<List<IBGEResult>> getIBGECode(Long id);
}
