package br.com.clean.arch.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class GivenParamDTO {

  private final BigDecimal value;
  private final String orderDescription;

  private GivenParamDTO(BigDecimal value, String orderDescription) {
    this.value = value;
    this.orderDescription = orderDescription;
  }

  @Override
  public String toString() {
    return String.format("GivenParam{value=%s, orderDescription='%s'}", value, orderDescription);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GivenParamDTO)) {
      return false;
    }
    GivenParamDTO that = (GivenParamDTO) o;
    return getValue().equals(that.getValue())
        && Objects.equals(getOrderDescription(), that.getOrderDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue(), getOrderDescription());
  }

  public BigDecimal getValue() {
    return value;
  }

  public String getOrderDescription() {
    return orderDescription;
  }

  public static GivenParamBuilder builder() {
    return new GivenParamBuilder();
  }

  public static class GivenParamBuilder {

    private BigDecimal value;
    private String orderDescription;

    public GivenParamBuilder value(BigDecimal value) {
      this.value = value;
      return this;
    }

    public GivenParamBuilder orderDescription(String orderDescription) {
      this.orderDescription = orderDescription;
      return this;
    }

    public GivenParamDTO build() {
      return new GivenParamDTO(this.value, this.orderDescription);
    }
  }
}
