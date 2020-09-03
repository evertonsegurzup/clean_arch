package br.com.clean.arch.domain.usecase.multiply.impl;

import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.multiply.MultiplyUseCase;
import br.com.clean.arch.domain.dto.GivenParamDTO;

class MultiplyValueUseCase implements MultiplyUseCase {

  @Override
  public ResultHistoryEntity calculate(GivenParamDTO firstParam, GivenParamDTO secondParam) {
    var result = firstParam.getValue().multiply(secondParam.getValue());
    return ResultHistoryEntity.builder().total(result).build();
  }
}
