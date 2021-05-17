package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpImpl implements Http{

    @Override
    public String get(String targetUrl) throws IOException {
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        int responseCdoe = conn.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream());
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null ) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("RESPONSE CODE: " + responseCdoe);

        return response.toString();
    }
}
