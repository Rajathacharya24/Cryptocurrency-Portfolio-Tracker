import java.util.*;
import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.stream.Collectors;

class Portfolio {
    private final Map<String, Double> holdings = new HashMap<>();

    public void addHolding(String symbol, double amount) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0.0) + amount);
    }

    public void removeHolding(String symbol) {
        holdings.remove(symbol);
    }

    public void printPortfolio() throws IOException {
        if (holdings.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\nYour Portfolio:");
        double totalValue = 0.0;
        Map<String, Double> prices = fetchPrices();
        for (Map.Entry<String, Double> entry : holdings.entrySet()) {
            String symbol = entry.getKey();
            double amount = entry.getValue();
            double price = prices.getOrDefault(symbol, 0.0);
            double value = price * amount;
            totalValue += value;
            System.out.printf("%s: %.4f (%.2f USD each) = %.2f USD\n", symbol, amount, price, value);
        }
        System.out.printf("Total Portfolio Value: %.2f USD\n", totalValue);
    }

    private Map<String, Double> fetchPrices() throws IOException {
        if (holdings.isEmpty()) return Collections.emptyMap();
        String ids = holdings.keySet().stream()
                .map(this::symbolToId)
                .filter(Objects::nonNull)
                .collect(Collectors.joining("%2C"));
        if (ids.isEmpty()) return Collections.emptyMap();
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + ids + "&vs_currencies=usd";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return parsePrices(response.body());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted");
        }
    }

    private Map<String, Double> parsePrices(String json) {
        Map<String, Double> prices = new HashMap<>();
        for (String symbol : holdings.keySet()) {
            String id = symbolToId(symbol);
            if (id == null) continue;
            String search = '"' + id + '"';
            int idx = json.indexOf(search);
            if (idx != -1) {
                int usdIdx = json.indexOf("usd", idx);
                int colonIdx = json.indexOf(':', usdIdx);
                int endIdx = json.indexOf('}', colonIdx);
                if (usdIdx != -1 && colonIdx != -1 && endIdx != -1) {
                    String priceStr = json.substring(colonIdx + 1, endIdx).replaceAll("[^0-9.]+", "");
                    try {
                        prices.put(symbol, Double.parseDouble(priceStr));
                    } catch (NumberFormatException ignored) {}
                }
            }
        }
        return prices;
    }

    private String symbolToId(String symbol) {
        switch (symbol) {
            case "BTC": return "bitcoin";
            case "ETH": return "ethereum";
            case "ADA": return "cardano";
            case "BNB": return "binancecoin";
            case "SOL": return "solana";
            case "XRP": return "ripple";
            case "DOGE": return "dogecoin";
            case "DOT": return "polkadot";
            case "MATIC": return "matic-network";
            case "LTC": return "litecoin";
            default: return null;
        }
    }
}
