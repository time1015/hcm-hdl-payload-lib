package me.time1015.hcm.hdl.file.data;

public final class HdlEmptyLine implements HdlDataLine {
  public static HdlEmptyLine INSTANCE = new HdlEmptyLine();

  private HdlEmptyLine() {}

  @Override
  public String line() {
    return "".intern();
  }
}
