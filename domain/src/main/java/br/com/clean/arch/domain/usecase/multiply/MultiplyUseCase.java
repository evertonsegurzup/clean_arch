package br.com.clean.arch.domain.usecase.multiply;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;

public interface MultiplyUseCase {

  ResultHistoryEntity calculate(GivenParamDTO firstParam, GivenParamDTO secondParam);
}
