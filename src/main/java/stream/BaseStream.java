package stream;

import java.io.Closeable;
import java.io.IOException;

public abstract class BaseStream {
    public static void close(Closeable c) {
        if (c == null) return;
        try {
            c.close();
        } catch (IOException e) {
            System.out.println("Stream closing error");
        }
    }
}
