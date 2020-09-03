package br.com.clean.arch.controller.rest;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.RequestAttribute;

@Controller("/multiply")
public interface MultiplyController {

  @Post
  HttpResponse<ResultHistoryEntity> multiply(
      @RequestAttribute("X-first-param") GivenParamDTO firstParam,
      @RequestAttribute("X-second-param") GivenParamDTO secondParam);

  @Post("/unique-param")
  HttpResponse<ResultHistoryEntity> multiplyToFifteen(
      @RequestAttribute("X-param") GivenParamDTO firstParam);
}
