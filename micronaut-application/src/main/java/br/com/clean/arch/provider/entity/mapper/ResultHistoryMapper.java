package br.com.clean.arch.provider.entity.mapper;

import br.com.clean.arch.domain.entity.ResultHistoryEntity;

public interface ResultHistoryMapper {

  ResultHistoryEntity map(br.com.clean.arch.provider.entity.ResultHistoryEntity entity);

  br.com.clean.arch.provider.entity.ResultHistoryEntity map(ResultHistoryEntity resultHistory);
}
