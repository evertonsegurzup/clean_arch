package br.com.clean.arch.provider.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "result_history")
@Table
public class ResultHistoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid4")
  @GenericGenerator(name = "uuid4", strategy = "uuid4")
  private UUID id;

  @Column private String values;

  @Column private BigDecimal total;

  ResultHistoryEntity(UUID id, String values, BigDecimal total) {
    this.id = id;
    this.values = values;
    this.total = total;
  }

  public ResultHistoryEntity() {}

  public static ResultHistoryEntityBuilder builder() {
    return new ResultHistoryEntityBuilder();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getValues() {
    return values;
  }

  public void setValues(String values) {
    this.values = values;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ResultHistoryEntity)) {
      return false;
    }
    final ResultHistoryEntity other = (ResultHistoryEntity) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$values = this.getValues();
    final Object other$values = other.getValues();
    if (this$values == null ? other$values != null : !this$values.equals(other$values)) {
      return false;
    }
    final Object this$total = this.getTotal();
    final Object other$total = other.getTotal();
    return Objects.equals(this$total, other$total);
  }

  protected boolean canEqual(final Object other) {
    return other instanceof ResultHistoryEntity;
  }

  @Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $values = this.getValues();
    result = result * PRIME + ($values == null ? 43 : $values.hashCode());
    final Object $total = this.getTotal();
    result = result * PRIME + ($total == null ? 43 : $total.hashCode());
    return result;
  }

  public String toString() {
    return String.format(
        "ResultHistoryEntity(id=%s, values=%s, total=%s)",
        this.getId(), this.getValues(), this.getTotal());
  }

  public static class ResultHistoryEntityBuilder {

    private UUID id;
    private String values;
    private BigDecimal total;

    ResultHistoryEntityBuilder() {}

    public ResultHistoryEntityBuilder id(UUID id) {
      this.id = id;
      return this;
    }

    public ResultHistoryEntityBuilder values(String values) {
      this.values = values;
      return this;
    }

    public ResultHistoryEntityBuilder total(BigDecimal total) {
      this.total = total;
      return this;
    }

    public ResultHistoryEntity build() {
      return new ResultHistoryEntity(id, values, total);
    }

    public String toString() {
      return "ResultHistoryEntity.ResultHistoryEntityBuilder(id="
          + this.id
          + ", values="
          + this.values
          + ", total="
          + this.total
          + ")";
    }
  }
}
