package stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cached extends BaseStream {
    public static void writeCourceData() {

    }

    public static void readCourceData() {
        FileReader in = null;
        BufferedReader reader = null;
        try {
            in = new FileReader("cached/currency_data.txt");
            reader = new BufferedReader(in);
            while (reader.readLine() != null) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in);
            close(reader);
        }
    }
}
