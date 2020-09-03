package br.com.clean.arch.domain.usecase.subtract;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;

public interface SubtractUseCase {

  ResultHistoryEntity calculate(GivenParamDTO firstParam, GivenParamDTO secondParam);

}
