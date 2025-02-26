package org.example;

import java.sql.*;

public class BankOperations {

    // CREATE
    public static void createAccount(String name, double initialBalance) {
        String query = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setDouble(2, initialBalance);
            stmt.executeUpdate();
            System.out.println("Account created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // fetch account details
    public static BankAccount getAccount(int accountId) {
        String query = "SELECT * FROM accounts WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BankAccount(
                        rs.getInt("account_id"),
                        rs.getString("name"),
                        rs.getDouble("balance")
                );
            } else {
                System.out.println("Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE: add money
    public static void deposit(int accountId, double amount) {
        String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            if(amount>=0){
                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Deposit successful! New Balance: $" + getAccount(accountId).getBalance());
                } else {
                    System.out.println("Account not found!");
                }
            }
            else{
                System.out.println("Amount can't be negative");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Withdraw money
    public static void withdraw(int accountId, double amount) {
        BankAccount account = getAccount(accountId);
        if (account == null) return;

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        if(amount<0){
            System.out.println("Amount can't be negative");
            return;
        }

        String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
            System.out.println("Withdrawal successful! New Balance: $" + getAccount(accountId).getBalance());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteAccount(int accountId) {
        String query = "DELETE FROM accounts WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, accountId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Account not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

