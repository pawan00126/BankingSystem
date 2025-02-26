package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.println("===================");
            System.out.print("Choose an option: ");

            int choice = getValidIntInput(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine(); // consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double balance = getValidDoubleInput(sc);
                    BankOperations.createAccount(name, balance);
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    int accountId = getValidIntInput(sc);
                    BankAccount account = BankOperations.getAccount(accountId);
                    if (account != null) {
                        System.out.println("\n" + account);
                    }
                    break;

                case 3:
                    System.out.print("Enter account ID: ");
                    int depositId = getValidIntInput(sc);
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = getValidDoubleInput(sc);
                    BankOperations.deposit(depositId, depositAmount);
                    break;

                case 4:
                    System.out.print("Enter account ID: ");
                    int withdrawId = getValidIntInput(sc);
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = getValidDoubleInput(sc);
                    BankOperations.withdraw(withdrawId, withdrawAmount);
                    break;

                case 5:
                    System.out.print("Enter account ID to delete: ");
                    int deleteId = getValidIntInput(sc);
                    BankOperations.deleteAccount(deleteId);
                    break;

                case 6:
                    System.out.println("Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // ✅ Helper method to validate integer input
    private static int getValidIntInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
                sc.nextLine(); // Consume invalid input
            }
        }
    }

    // ✅ Helper method to validate double input
    private static double getValidDoubleInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a valid amount: ");
                sc.nextLine(); // Consume invalid input
            }
        }
    }
}
