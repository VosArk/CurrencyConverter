package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cache extends BaseStream {

    private static final String FILE_NAME = "cached\\currency_data.txt";

    public static void writeRateData(String inputCurr, String outputCurr, String value) {
        FileWriter writer = null;

        try {
            File file = new File(FILE_NAME);
            file.getParentFile().mkdirs();
            writer = new FileWriter(file, true);
            writer.write(inputCurr + " " + outputCurr + " " + value + " " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\n");
        } catch (IOException e) {
            System.out.println("Couldn't write cache");
        } finally {
            close(writer);
        }
    }

    public static String readRateData(String input, String output) {
        Scanner scanner = null;
        ArrayList<String> words = new ArrayList<>();
        try {
            File out = new File(FILE_NAME);
            scanner = new Scanner(out);
            while (scanner.hasNext()) {
                String line = scanner.next();
                words.add(line);
            }
        } catch (IOException e) {
            System.out.println("Cache wasn't created yet");
        } finally {
            close(scanner);
        }
        for (int i = 0; i < words.size(); i += 4) {
            if (words.get(i).equals(input) && words.get(i + 1).equals(output)
                    && words.get(i + 3).equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))) return words.get(i + 2);
        }
        return null;
    }
}
