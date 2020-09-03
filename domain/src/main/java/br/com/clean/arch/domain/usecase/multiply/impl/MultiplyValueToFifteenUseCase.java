package br.com.clean.arch.domain.usecase.multiply.impl;

import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.multiply.MultiplyHundredToFifteenOnZeroGivenUseCase;
import br.com.clean.arch.domain.dto.GivenParamDTO;
import java.math.BigDecimal;

class MultiplyValueToFifteenUseCase implements MultiplyHundredToFifteenOnZeroGivenUseCase {

  @Override
  public ResultHistoryEntity calculate(GivenParamDTO firstParam) {
    var result = firstParam.getValue().multiply(BigDecimal.valueOf(15));
    return ResultHistoryEntity.builder().total(result).build();
  }
}
