
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testGson {
    public static void main(String[] args) throws IOException {
        String apiKey = "9da90480a8e3923c4eec8515";
        String currency1 = "USD";
        String currency2 = "PLN";

        String url_str = "https://v3.exchangerate-api.com/pair/" + apiKey
                + "/" + currency1 + "/" + currency2;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        //convertToJSON
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = root.getAsJsonObject();

        //Accessing objects
        String req_status = jsonObject.get("result").getAsString();
        String req_rate = jsonObject.get("rate").getAsString();

        System.out.println("Status: " + req_status);
        System.out.println("From " + currency1 + " to " + currency2 + ".");
        System.out.println("Rate: " + req_rate);
    }
}
