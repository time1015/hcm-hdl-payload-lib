package me.time1015.hcm.hdl.file.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class HdlMetadataLine implements HdlDataLine {
  private final String name;
  private final List<String> headers;

  public HdlMetadataLine(String name, List<String> headers) {
    verifyName(name);
    verifyHeaders(headers);

    this.name = name;
    this.headers = new ArrayList<>(headers);
  }

  private void verifyName(String name) {
    Objects.requireNonNull(name, "name");

    if (name.isEmpty() || name.trim().isEmpty())
      throw new IllegalArgumentException("Empty name");
  }

  private void verifyHeaders(List<String> headers) {
    Objects.requireNonNull(headers, "headers");

    if (headers.isEmpty())
      throw new IllegalArgumentException("Empty headers");
    for (int idx = 0; idx < headers.size(); idx++) {
      String header = headers.get(idx);
      Objects.requireNonNull(header, "headers[i]");

      if (header.isEmpty() || header.trim().isEmpty())
        throw new IllegalArgumentException("Empty header[i]");
    }
  }

  public String name() {
    return name;
  }

  public List<String> headers() {
    return Collections.unmodifiableList(headers);
  }

  @Override
  public String line() {
    return Stream.of(
        Stream.of("METADATA", name),
        headers.stream()
      )
      .flatMap(s -> s)
      .collect(Collectors.joining("|"));
  }
}
