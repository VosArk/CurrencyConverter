import java.util.HashSet;

public enum CurrencyList {
    AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK,
    GBP, HKD, HRK, HUF, IDR, ILS, INR, JPY,
    KRW, MXN, MYR, NOK, NZD, PHP, PLN, RON,
    SEK, SGD, THB, TRY, USD, ZAR, EUR, RUB;

    public static HashSet<String> getCurrencies() {
        HashSet<String> values = new HashSet<>();
        for (CurrencyList currency : CurrencyList.values()) {
            values.add(currency.name());
        }
        return values;
    }
}
