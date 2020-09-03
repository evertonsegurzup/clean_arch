package br.com.clean.arch.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ResultHistoryEntity {

  private final UUID id;
  private final String values;
  private final BigDecimal total;

  private ResultHistoryEntity(UUID id, String values, BigDecimal total) {
    this.id = id;
    this.values = values;
    this.total = total;
  }

  public UUID getId() {
    return id;
  }

  public String getValues() {
    return values;
  }

  public BigDecimal getTotal() {
    return total;
  }

  @Override
  public String toString() {
    return String.format("ResultHistory{values='%s', total=%s}", values, total);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ResultHistoryEntity)) {
      return false;
    }
    ResultHistoryEntity that = (ResultHistoryEntity) o;
    return Objects.equals(values, that.values) && total.equals(that.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, total);
  }

  public static ResultHistoryBuilder builder() {
    return new ResultHistoryBuilder();
  }

  public static class ResultHistoryBuilder {

    ArrayList<BigDecimal> params;

    BigDecimal result;

    public ResultHistoryBuilder values(BigDecimal... params) {
      this.params.addAll(Arrays.asList(params));
      return this;
    }

    public ResultHistoryBuilder values(List<BigDecimal> otherParams, BigDecimal... params) {
      this.params.addAll(Arrays.asList(params));
      this.params.addAll(otherParams);
      return this;
    }

    public ResultHistoryBuilder total(BigDecimal result) {
      this.result = result;
      return this;
    }

    public ResultHistoryEntity build() {
      var givenParams = concatParams();
      return new ResultHistoryEntity(null, givenParams, this.result);
    }

    private String concatParams() {
      return this.params.stream().map(BigDecimal::toString).reduce(String::concat).orElse("");
    }
  }
}
