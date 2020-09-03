package br.com.clean.arch.domain.usecase.sum;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;

public interface SumUseCase {

  ResultHistoryEntity calculate(
      GivenParamDTO firstParam, GivenParamDTO secondParam, GivenParamDTO... otherParam);
}
