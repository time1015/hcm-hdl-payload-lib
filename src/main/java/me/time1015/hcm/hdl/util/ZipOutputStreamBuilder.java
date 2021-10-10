package me.time1015.hcm.hdl.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ZipOutputStreamBuilder {
  public static interface EntryStream {
    void writeTo(OutputStream stream) throws IOException; 
  }

  public static ZipOutputStreamBuilder newStream() {
    return new ZipOutputStreamBuilder();
  }

  ZipOutputStreamBuilder() {
    
  }

  public ZipOutputStreamBuilder directory(String name) {
    return this;
  }

  public ZipOutputStreamBuilder directory(ZipEntry dirEntry) {
    return this;
  }

  public ZipOutputStreamBuilder file(String name, EntryStream stream) {
    return this;
  }
  
  public ZipOutputStreamBuilder file(ZipEntry fileEntry, EntryStream stream) {
    return this;
  }

  public ZipOutputStream stream() throws IOException {
    return null;
  }
}
