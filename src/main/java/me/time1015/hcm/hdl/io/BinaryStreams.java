package me.time1015.hcm.hdl.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public final class BinaryStreams {
  public static InputStream nullInputStream() {
    return new NullInputStream();
  }

  private static final class NullInputStream extends InputStream {
    @Override public int read() throws IOException { return -1; }
  }

  public static OutputStream nullOutputStream() {
    return new NullOutputStream();
  }

  private static final class NullOutputStream extends OutputStream {
    @Override public void write(int b) throws IOException {}
  }
  
  public static void transfer(InputStream in, OutputStream out) throws IOException {
    Objects.requireNonNull(in, "in");
    Objects.requireNonNull(out, "out");

    BufferedInputStream bufferedIn = new BufferedInputStream(in);
    BufferedOutputStream bufferedOut = new BufferedOutputStream(out);

    for (int read = bufferedIn.read(); read != -1; read = bufferedIn.read())
      bufferedOut.write(read);
  }

  private BinaryStreams() {}
}
