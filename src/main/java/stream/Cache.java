package stream;

import java.io.*;

public class Cache extends BaseStream {

    private static final String FILE_NAME = "cached\\currency_data.txt";

    public static void writeRateData(String inputCurr, String outputCurr, String value) {
        FileWriter writer = null;

        try {
            File file = new File(FILE_NAME);
            file.getParentFile().mkdirs();
            writer = new FileWriter(file);
            writer.write(inputCurr + " " + outputCurr +" " + value + "\n");
        } catch (IOException e) {
            System.out.println("Couldn't write cache");
        } finally {
            close(writer);
        }
    }

    public static String readRateData() {
        FileReader out = null;
        BufferedReader reader = null;
        StringBuilder fileData = null;
        try {
            out = new FileReader(FILE_NAME);
            reader = new BufferedReader(out);
            fileData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.append(line);
            }
        } catch (IOException e) {
            System.out.println("Cache wasn't created yet");
        } finally {
            close(out);
            close(reader);
        }
        return fileData.toString();
    }
}
