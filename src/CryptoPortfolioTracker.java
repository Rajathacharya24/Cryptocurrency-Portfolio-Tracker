import java.util.*;
import java.io.IOException;

public class CryptoPortfolioTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Portfolio portfolio = new Portfolio();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCryptocurrency Portfolio Tracker");
            System.out.println("1. Add holding");
            System.out.println("2. Remove holding");
            System.out.println("3. View portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHolding();
                    break;
                case "2":
                    removeHolding();
                    break;
                case "3":
                    viewPortfolio();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addHolding() {
        System.out.print("Enter coin symbol (e.g., BTC): ");
        String symbol = scanner.nextLine().toUpperCase();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        portfolio.addHolding(symbol, amount);
        System.out.println("Added " + amount + " " + symbol);
    }

    private static void removeHolding() {
        System.out.print("Enter coin symbol to remove: ");
        String symbol = scanner.nextLine().toUpperCase();
        portfolio.removeHolding(symbol);
        System.out.println("Removed " + symbol);
    }

    private static void viewPortfolio() {
        try {
            portfolio.printPortfolio();
        } catch (IOException e) {
            System.out.println("Error fetching prices: " + e.getMessage());
        }
    }
}
