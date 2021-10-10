package me.time1015.hcm.hdl.file.data;

import java.util.Objects;
import java.util.StringJoiner;

public final class HdlSetLine implements HdlDataLine {
  private final String name;
  private final String value;

  public HdlSetLine(String name, String value) {
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(value, "value");

    if (name.isEmpty() || name.trim().isEmpty())
      throw new IllegalArgumentException("Empty name");
    if (value.isEmpty() || value.trim().isEmpty())
      throw new IllegalArgumentException("Empty value");

    this.name = name;
    this.value = value;
  }

  @Override
  public String line() {
    return new StringJoiner(" ")
      .add(name)
      .add(value)
      .toString();
  }
}
