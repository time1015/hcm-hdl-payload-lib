package me.time1015.hcm.hdl.file;

import java.io.IOException;
import java.io.OutputStream;

public interface HdlFile {
  void writeTo(OutputStream out) throws IOException;
}
