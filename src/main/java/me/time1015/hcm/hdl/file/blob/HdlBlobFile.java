package me.time1015.hcm.hdl.file.blob;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

import me.time1015.hcm.hdl.file.HdlFile;
import me.time1015.hcm.hdl.io.BinaryStreams;

public final class HdlBlobFile implements HdlFile {
  private final HdlBlobFileSupplier supplier;

  public HdlBlobFile(HdlBlobFileSupplier supplier) {
    this.supplier = Objects.requireNonNull(supplier, "supplier");
  }

  @Override
  public void writeTo(OutputStream out) throws IOException {
    try (InputStream in = supplier.get()) {
      BinaryStreams.transfer(in, out);
    }
  }
}
