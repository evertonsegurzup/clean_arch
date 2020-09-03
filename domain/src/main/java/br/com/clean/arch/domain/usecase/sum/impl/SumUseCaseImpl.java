package br.com.clean.arch.domain.usecase.sum.impl;

import br.com.clean.arch.domain.dto.GivenParamDTO;
import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.domain.usecase.sum.SumUseCase;
import br.com.clean.arch.domain.usecase.sum.SumWithThreeParamsUseCase;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class SumUseCaseImpl implements SumUseCase {

  private final SumWithThreeParamsUseCase sumWithThreeParamsUseCase;

  @Inject
  public SumUseCaseImpl(SumWithThreeParamsUseCase sumWithThreeParamsUseCase) {
    this.sumWithThreeParamsUseCase = sumWithThreeParamsUseCase;
  }

  @Override
  public ResultHistoryEntity calculate(
      GivenParamDTO firstParam, GivenParamDTO secondParam, GivenParamDTO... otherParam) {
    return Optional.ofNullable(otherParam)
        .map(
            givenParams ->
                sumWithThreeParamsUseCase.calculate(
                    firstParam,
                    secondParam,
                    GivenParamDTO.builder().value(sumThirdParam(otherParam)).build()))
        .map(
            resultHistory ->
                ResultHistoryEntity.builder()
                    .total(resultHistory.getTotal())
                    .values(
                        Arrays.stream(otherParam)
                            .map(GivenParamDTO::getValue)
                            .collect(Collectors.toList()),
                        firstParam.getValue(),
                        secondParam.getValue())
                    .build())
        .orElseGet(
            () ->
                ResultHistoryEntity.builder()
                    .total(firstParam.getValue().add(secondParam.getValue()))
                    .values(firstParam.getValue(), secondParam.getValue())
                    .build());
  }

  private BigDecimal sumThirdParam(GivenParamDTO[] otherParam) {
    return Arrays.stream(otherParam)
        .map(GivenParamDTO::getValue)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }
}
