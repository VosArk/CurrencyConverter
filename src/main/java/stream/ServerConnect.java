package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ServerConnect extends BaseStream {

    public static String getResponse(String url) {
        String response = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL address = new URL(url);
            in = address.openStream();
            reader = new BufferedReader(new InputStreamReader(in));
            response = reader.readLine();
        } catch (IOException e) {
            System.out.println("Internal server error");
        } finally {
            close(in);
            close(reader);
        }
        return response;
    }
}
