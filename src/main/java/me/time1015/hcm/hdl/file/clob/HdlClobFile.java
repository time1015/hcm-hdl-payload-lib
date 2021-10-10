package me.time1015.hcm.hdl.file.clob;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Objects;

import me.time1015.hcm.hdl.file.HdlFile;
import me.time1015.hcm.hdl.io.CharacterStreams;

public final class HdlClobFile implements HdlFile {
  private final HdlClobFileSupplier supplier;

  public HdlClobFile(HdlClobFileSupplier supplier) {
    this.supplier = Objects.requireNonNull(supplier, "supplier");
  }

  @Override
  public void writeTo(OutputStream out) throws IOException {
    try (Reader reader = supplier.get()) {
      CharacterStreams.transfer(reader, new OutputStreamWriter(out));
    }
  }
}
