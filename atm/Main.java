import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }
}

class Transaction {
    private String transactionType;
    private double amount;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

class Withdrawal extends Transaction {
    public Withdrawal(double amount) {
        super("Withdrawal", amount);
    }
}

class Deposit extends Transaction {
    public Deposit(double amount) {
        super("Deposit", amount);
    }
}

class Transfer extends Transaction {
    private String recipient;

    public Transfer(double amount, String recipient) {
        super("Transfer", amount);
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }
}

class ATMSystem {
    private User currentUser;
    private List<Transaction> transactionHistory;

    public ATMSystem() {
        this.transactionHistory = new ArrayList<>();
    }

    public void start() {
        // Simulate user login
        loginUser();

        // ATM functionalities
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Exiting the ATM system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Validate user credentials (this is a simplified example)
        if (validateUser(userId, pin)) {
            currentUser = new User(userId, pin);
            System.out.println("Login successful. Welcome, " + currentUser.getUserId() + "!");
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
            System.exit(0);
        }
    }

    private boolean validateUser(String userId, String pin) {
        // In a real application, you would check against a database or some other
        // authentication mechanism.
        // This is a simplified example.
        return "user123".equals(userId) && "1234".equals(pin);
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Select option: ");
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getTransactionType() + ": " + transaction.getAmount());
        }
    }

    private void performWithdrawal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        transactionHistory.add(new Withdrawal(amount));
        System.out.println("Withdrawal successful. Current balance: " + getBalance());
    }

    private void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        transactionHistory.add(new Deposit(amount));
        System.out.println("Deposit successful. Current balance: " + getBalance());
    }

    private void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter recipient's user ID: ");
        String recipient = scanner.next();
        transactionHistory.add(new Transfer(amount, recipient));
        System.out.println("Transfer successful. Current balance: " + getBalance());
    }

    private double getBalance() {
        // In a real application, you would calculate the balance based on the
        // transaction history.
        // This is a simplified example.
        double balance = 0;
        for (Transaction transaction : transactionHistory) {
            if (transaction instanceof Deposit) {
                balance += transaction.getAmount();
            } else if (transaction instanceof Withdrawal || transaction instanceof Transfer) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        ATMSystem atmSystem = new ATMSystem();
        atmSystem.start();
    }
}
