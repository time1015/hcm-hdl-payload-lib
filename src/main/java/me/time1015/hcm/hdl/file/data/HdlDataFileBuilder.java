package me.time1015.hcm.hdl.file.data;

import java.util.Map;

public final class HdlDataFileBuilder {
  public static HdlDataFileBuilder newBuilder() {
    return new HdlDataFileBuilder();
  }

  private HdlDataFileBuilder() {
    
  }

  public HdlDataFileBuilder merge(String name, Map<String, String> record) {
    return this;
  }

  public HdlDataFileBuilder delete(String name, Map<String, String> record) {
    return this;
  }

  public HdlDataFileBuilder comment(String comment) {
    return this;
  }

  public HdlDataFileBuilder set(String name, String value) {
    return this;
  }

  public HdlDataFile build() {
    return null;
  }
}
