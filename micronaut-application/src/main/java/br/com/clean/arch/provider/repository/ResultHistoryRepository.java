package br.com.clean.arch.provider.repository;

import br.com.clean.arch.provider.entity.ResultHistoryEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface ResultHistoryRepository extends JpaRepository<ResultHistoryEntity, UUID> {}
