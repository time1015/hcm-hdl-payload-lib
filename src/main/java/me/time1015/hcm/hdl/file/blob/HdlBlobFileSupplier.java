package me.time1015.hcm.hdl.file.blob;

import java.io.IOException;
import java.io.InputStream;

public interface HdlBlobFileSupplier {
  InputStream get() throws IOException;
}