import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import stream.ServerConnect;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String BASE_URL = "http://api.fixer.io/latest?base=%s&symbols=%s";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter from currency:\n");
        String inputCurrency = scanner.next().toUpperCase();
        System.out.println("Enter to currency:\n");
        String outputCurrency = scanner.next().toUpperCase();

        if (CurrencyList.getCurrencies().contains(inputCurrency)
                && CurrencyList.getCurrencies().contains(outputCurrency)
                && !Objects.equals(inputCurrency, outputCurrency)) {

            String jsonResult = ServerConnect.getResponse(String.format(BASE_URL, inputCurrency, outputCurrency));

            Gson gson = new GsonBuilder().registerTypeAdapter(RateObject.class, new RatesDeserializer()).create();
            ApiResponse apiResponse = gson.fromJson(jsonResult, ApiResponse.class);
            String answer = apiResponse.getRates().getRate().toString();

            System.out.println(inputCurrency.toUpperCase() + " => " + outputCurrency.toUpperCase() + " : " + answer);
        } else {
            System.out.println("Incorrect data");
        }
    }
}
