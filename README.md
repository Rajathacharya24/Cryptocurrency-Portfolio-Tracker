# Cryptocurrency Portfolio Tracker (Java)

This is a command-line Java application to track your cryptocurrency portfolio. It allows you to add, remove, and view your crypto holdings, and fetches real-time prices from a public API.

## Features
- Add, remove, and view cryptocurrency holdings
- Fetch real-time prices from a public API (e.g., CoinGecko)
- Calculate and display total portfolio value
- Simple command-line interface

## Getting Started
1. Ensure you have Java (JDK 11+) installed.
2. Compile the project:
   ```
   javac -d bin src/*.java
   ```
3. Run the application:
   ```
   java -cp bin CryptoPortfolioTracker
   ```

## Project Structure
- `src/` - Java source files
- `bin/` - Compiled classes

## Dependencies
- Uses Java's built-in HTTP client (Java 11+)

## Notes
- API calls use CoinGecko's free public API.
- This is a simple starter project. You can extend it with more features!
