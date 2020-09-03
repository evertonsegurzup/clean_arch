package br.com.clean.arch.provider.entity.mapper.impl;

import br.com.clean.arch.domain.entity.ResultHistoryEntity;
import br.com.clean.arch.provider.entity.mapper.ResultHistoryMapper;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

@Singleton
class ResultHistoryMapperImpl implements ResultHistoryMapper {

  @Override
  @NotNull
  public ResultHistoryEntity map(br.com.clean.arch.provider.entity.ResultHistoryEntity entity) {
    return ResultHistoryEntity.builder().total(entity.getTotal()).build();
  }

  @Override
  @NotNull
  public br.com.clean.arch.provider.entity.ResultHistoryEntity map(
      ResultHistoryEntity resultHistory) {
    return br.com.clean.arch.provider.entity.ResultHistoryEntity.builder().total(resultHistory.getTotal()).build();
  }
}
