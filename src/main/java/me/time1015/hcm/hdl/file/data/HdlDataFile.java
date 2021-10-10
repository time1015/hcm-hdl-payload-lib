package me.time1015.hcm.hdl.file.data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.time1015.hcm.hdl.file.HdlFile;

public final class HdlDataFile implements HdlFile {
  private final List<HdlDataLine> lines;

  public HdlDataFile(List<HdlDataLine> lines) {
    this.lines = new ArrayList<>(Objects.requireNonNull(lines, "lines"));
  }

  public List<HdlDataLine> lines() {
    return Collections.unmodifiableList(lines);
  }

  @Override
  public void writeTo(OutputStream out) throws IOException {
    final String NEW_LINE = "\n".intern();

    new OutputStreamWriter(out).write(
      lines.stream()
        .map(HdlDataLine::line)
        .collect(Collectors.joining(NEW_LINE))
    );
  }
}
