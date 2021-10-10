package me.time1015.hcm.hdl.file.data;

import java.util.StringJoiner;

public final class HdlCommentLine implements HdlDataLine {
  private final String comment;

  public HdlCommentLine(String comment) {
    this.comment = comment;
  }

  public String comment() {
    return comment;
  }

  @Override
  public String line() {
    return new StringJoiner(" ")
      .add("COMMENT")
      .add(comment == null ? "<null>" : comment)
      .toString();
  }
}
