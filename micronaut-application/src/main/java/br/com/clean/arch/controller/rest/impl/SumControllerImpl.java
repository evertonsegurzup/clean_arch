package br.com.clean.arch.controller.rest.impl;

import br.com.clean.arch.provider.entity.mapper.ResultHistoryMapper;
import br.com.clean.arch.provider.repository.ResultHistoryRepository;
import br.com.clean.arch.controller.rest.SumController;
import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.sum.SumUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.RequestAttribute;
import javax.inject.Inject;
import javax.inject.Named;

@Controller(value = "/sum")
class SumControllerImpl implements SumController {

  private final @Named("Implementation") SumUseCase sumUseCase;
  private final ResultHistoryRepository resultHistoryRepository;
  private final ResultHistoryMapper mapper;

  @Inject
  SumControllerImpl(
      SumUseCase sumUseCase,
      ResultHistoryRepository resultHistoryRepository,
      ResultHistoryMapper mapper) {
    this.sumUseCase = sumUseCase;
    this.resultHistoryRepository = resultHistoryRepository;
    this.mapper = mapper;
  }

  @Override
  @Post
  public HttpResponse<ResultHistoryEntity> calculateSum(
      @RequestAttribute("X-first-param") GivenParamDTO firstParam,
      @RequestAttribute("X-second-param") GivenParamDTO secondParam,
      @RequestAttribute("X-other-param") GivenParamDTO... otherParam) {
    final var resultHistoryValue = sumUseCase.calculate(firstParam, secondParam, otherParam);
    final var map = mapper.map(resultHistoryValue);
    resultHistoryRepository.save(map);
    return HttpResponse.created(null);
  }
}
