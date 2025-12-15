import java.util.*;

public class ATMInterface {
    static Scanner scanner = new Scanner(System.in);
    static String userId = "user123";
    static String userPin = "1234";
    static double balance = 1000.0;
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Interface");

        
        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        if (inputId.equals(userId) && inputPin.equals(userPin)) {
            showMenu();
        } else {
            System.out.println(" Invalid credentials. Access denied.");
        }
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: showTransactionHistory();
                case 2: withdraw();
                case 3: deposit();
                case 4: transfer();
                case 5: System.out.println("Thank you for using the ATM. Goodbye!");
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    public static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }

    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Deposit successful. Balance: " + balance);
    }

    public static void transfer() {
        scanner.nextLine(); 
        System.out.print("Enter recipient ID: ");
        String recipient = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred " + amount + " to " + recipient);
            System.out.println("Transfer successful. Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}