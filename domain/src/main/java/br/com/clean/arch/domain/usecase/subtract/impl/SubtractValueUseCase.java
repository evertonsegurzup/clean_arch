package br.com.clean.arch.domain.usecase.subtract.impl;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.subtract.SubtractUseCase;

class SubtractValueUseCase implements SubtractUseCase {

  @Override
  public ResultHistoryEntity calculate(GivenParamDTO firstParam, GivenParamDTO secondParam) {
    final var result = firstParam.getValue().subtract(secondParam.getValue());
    return ResultHistoryEntity.builder().total(result).build();
  }
}
