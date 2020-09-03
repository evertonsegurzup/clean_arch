package br.com.clean.arch.domain.usecase.sum.impl;

import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.usecase.sum.SumWithThreeParamsUseCase;
import javax.inject.Singleton;

@Singleton
class SumValueWithThreeParamsUseCase implements SumWithThreeParamsUseCase {

  @Override
  public ResultHistoryEntity calculate(
      GivenParamDTO firstParam, GivenParamDTO secondParam, GivenParamDTO thirdParam) {
    return ResultHistoryEntity.builder()
        .total(firstParam.getValue().add(secondParam.getValue().add(thirdParam.getValue())))
        .build();
  }
}
