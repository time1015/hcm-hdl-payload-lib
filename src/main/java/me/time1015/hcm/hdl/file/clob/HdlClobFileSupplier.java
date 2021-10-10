package me.time1015.hcm.hdl.file.clob;

import java.io.IOException;
import java.io.Reader;

public interface HdlClobFileSupplier {
  Reader get() throws IOException;
}