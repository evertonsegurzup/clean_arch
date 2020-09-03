package br.com.clean.arch.controller.rest.impl;

import br.com.clean.arch.provider.entity.mapper.ResultHistoryMapper;
import br.com.clean.arch.provider.repository.ResultHistoryRepository;
import br.com.clean.arch.controller.rest.SubtractController;
import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.subtract.SubtractUseCase;
import io.micronaut.http.HttpResponse;

class SubtractControllerImpl implements SubtractController {

  private final SubtractUseCase subtractUseCase;
  private final ResultHistoryRepository resultHistoryRepository;
  private final ResultHistoryMapper mapper;

  SubtractControllerImpl(
      SubtractUseCase subtractUseCase,
      ResultHistoryRepository resultHistoryRepository,
      ResultHistoryMapper mapper) {
    this.subtractUseCase = subtractUseCase;
    this.resultHistoryRepository = resultHistoryRepository;
    this.mapper = mapper;
  }

  @Override
  public HttpResponse<ResultHistoryEntity> calculateSubtract(
      GivenParamDTO firstParam, GivenParamDTO secondParam) {

    final var resultHistoryValue = subtractUseCase.calculate(firstParam, secondParam);

    final var map = mapper.map(resultHistoryValue);
    resultHistoryRepository.save(map);

    return HttpResponse.created(null);
  }
}
