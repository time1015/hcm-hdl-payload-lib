package me.time1015.hcm.hdl.file.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class HdlDeleteLine implements HdlDataLine {
  private final String name;
  private final List<String> values;

  public HdlDeleteLine(String name, List<String> values) {
    verifyName(name);
    verifyValues(values);

    this.name = name;
    this.values = new ArrayList<>(values);
  }

  private void verifyName(String name) {
    Objects.requireNonNull(name, "name");

    if (name.isEmpty() || name.trim().isEmpty())
      throw new IllegalArgumentException("Empty name");
  }

  private void verifyValues(List<String> values) {
    Objects.requireNonNull(values, "values");

    if (values.isEmpty())
      throw new IllegalArgumentException("Empty values");
    for (int idx = 0; idx < values.size(); idx++)
      Objects.requireNonNull(values.get(idx), "values[i]");
  }

  public String name() {
    return name;
  }

  public List<String> values() {
    return Collections.unmodifiableList(values);
  }

  @Override
  public String line() {
    return Stream.of(
        Stream.of("DELETE", name),
        values.stream()
      )
      .flatMap(s -> s)
      .collect(Collectors.joining("|"));
  }
}
