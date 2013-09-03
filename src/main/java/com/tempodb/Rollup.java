package com.tempodb;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.Period;

import static com.tempodb.Preconditions.*;


public class Rollup {
  private Period period = null;
  private Fold fold = null;

  public Rollup() { }

  public Rollup(@JsonProperty("period") Period period, @JsonProperty("fold") Fold fold) {
    this.period = checkNotNull(period);
    this.fold = checkNotNull(fold);
  }

  @JsonProperty("period")
  public Period getPeriod() { return period; }
  public void setPeriod(Period period) { this.period = checkNotNull(period); }

  @JsonProperty("fold")
  public Fold getFold() { return fold; }
  public void setFold(Fold fold) { this.fold = checkNotNull(fold); }

  @Override
  public String toString() {
    return String.format("Rollup(period=%s,fold=%s)", period.toString(), fold.toString().toLowerCase());
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(13, 41)
      .append(period)
      .append(fold)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(obj == this) return true;
    if(!(obj instanceof Rollup)) return false;

    Rollup rhs = (Rollup)obj;
    return new EqualsBuilder()
      .append(period, rhs.period)
      .append(fold, rhs.fold)
      .isEquals();
  }
}
