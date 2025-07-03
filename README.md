# 💰 Cryptocurrency Portfolio Tracker (Java CLI)

A simple Java command-line application to track your cryptocurrency holdings with **real-time price updates** using the [CoinGecko API](https://www.coingecko.com/en/api).

---

## 🧠 Overview

This app allows users to:

- Add or remove crypto coins to their portfolio.
- Fetch **real-time prices** for supported coins.
- View total portfolio value in **USD**.
- Interact using a simple **text-based CLI**.

Built using **Java 11** and the built-in `HttpClient` for web API integration.

---

## 🧩 Features

| Feature                  | Description                                                                 |
|--------------------------|-----------------------------------------------------------------------------|
| ➕ Add Holdings           | Add a crypto coin (e.g., BTC, ETH) with a specific amount to your portfolio. |
| ➖ Remove Holdings        | Remove all or part of a coin's holdings.                                    |
| 🌐 Real-Time Prices      | Fetches live prices using CoinGecko’s free API.                             |
| 📊 Portfolio Summary     | Calculates and displays your total value in USD.                            |
| 🖥️ CLI Interface         | Works entirely in terminal — no GUI needed.                                 |

---

## 🧱 Technologies Used

- Java 11+
- Java `HttpClient`
- JSON parsing (`org.json`, `Gson`, or `Jackson`)
- CoinGecko Public API

---

## 🔧 Used Tools

| Tool                    | Purpose                                           |
|-------------------------|---------------------------------------------------|
| Java SDK (11+)          | Core development language                         |
| VS Code / IntelliJ IDE | Code editing and project structure                |
| Terminal / CMD          | Running the CLI application                       |
| [CoinGecko API](https://www.coingecko.com/en/api) | Fetching real-time crypto prices              |
| Git & GitHub            | Version control and project hosting               |
| JSON Library (Gson or org.json) | Parsing the JSON response from API calls       |

---

## 🚀 How to Run

### ✅ Prerequisites

- Java 11+ installed  
- Internet connection (for price fetching)

### 📦 Compile & Run

```bash
javac Main.java
java Main
