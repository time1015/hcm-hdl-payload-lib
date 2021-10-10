package me.time1015.hcm.hdl.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Objects;

public final class CharacterStreams {
  public static Reader nullReader() {
    return new NullReader();
  }

  private static final class NullReader extends Reader {
    @Override public int read(char[] cbuf, int off, int len) throws IOException { return 0; }

    @Override public void close() throws IOException {}
  }

  public static Writer nullWriter() {
    return new NullWriter();
  }

  private static final class NullWriter extends Writer {
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {}

    @Override
    public void flush() throws IOException {}

    @Override
    public void close() throws IOException {}
  }
  
  public static void transfer(Reader in, Writer out) throws IOException {
    Objects.requireNonNull(in, "in");
    Objects.requireNonNull(out, "out");

    BufferedReader bufferedIn = new BufferedReader(in);
    BufferedWriter bufferedOut = new BufferedWriter(out);

    for (int read = bufferedIn.read(); read != -1; read = bufferedIn.read())
      bufferedOut.write(read);
  }
}
