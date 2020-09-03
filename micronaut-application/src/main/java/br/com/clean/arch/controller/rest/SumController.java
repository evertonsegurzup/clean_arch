package br.com.clean.arch.controller.rest;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import io.micronaut.http.HttpResponse;

public interface SumController {

  HttpResponse<ResultHistoryEntity> calculateSum(
      GivenParamDTO firstParam, GivenParamDTO secondParam, GivenParamDTO... otherParam);
}
