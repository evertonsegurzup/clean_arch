package br.com.clean.arch.controller.rest.impl;

import br.com.clean.arch.provider.entity.mapper.ResultHistoryMapper;
import br.com.clean.arch.provider.repository.ResultHistoryRepository;
import br.com.clean.arch.controller.rest.MultiplyController;
import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.multiply.MultiplyHundredToFifteenOnZeroGivenUseCase;
import br.com.clean.arch.domain.usecase.multiply.MultiplyUseCase;
import io.micronaut.http.HttpResponse;
import javax.inject.Inject;

class MultiplyControllerImpl implements MultiplyController {

  private final MultiplyUseCase multiplyUseCase;
  private final MultiplyHundredToFifteenOnZeroGivenUseCase
      multiplyHundredToFifteenOnZeroGivenUseCase;
  private final ResultHistoryRepository resultHistoryRepository;
  private final ResultHistoryMapper mapper;

  @Inject
  MultiplyControllerImpl(
      MultiplyUseCase multiplyUseCase,
      MultiplyHundredToFifteenOnZeroGivenUseCase multiplyHundredToFifteenOnZeroGivenUseCase,
      ResultHistoryRepository resultHistoryRepository,
      ResultHistoryMapper mapper) {
    this.multiplyUseCase = multiplyUseCase;
    this.multiplyHundredToFifteenOnZeroGivenUseCase = multiplyHundredToFifteenOnZeroGivenUseCase;
    this.resultHistoryRepository = resultHistoryRepository;
    this.mapper = mapper;
  }

  @Override
  public HttpResponse<ResultHistoryEntity> multiply(
      GivenParamDTO firstParam, GivenParamDTO secondParam) {
    final var resultHistoryValue = multiplyUseCase.calculate(firstParam, secondParam);

    final var map = mapper.map(resultHistoryValue);
    resultHistoryRepository.save(map);
    return HttpResponse.created(null);
  }

  @Override
  public HttpResponse<ResultHistoryEntity> multiplyToFifteen(GivenParamDTO firstParam) {
    final var resultHistoryValue = multiplyHundredToFifteenOnZeroGivenUseCase.calculate(firstParam);

    final var map = mapper.map(resultHistoryValue);
    resultHistoryRepository.save(map);
    return HttpResponse.created(null);
  }
}
