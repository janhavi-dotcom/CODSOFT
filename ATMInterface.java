import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful!");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful!");
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Display ATM menu
    public void displayMenu() {
        System.out.println("\n====== ATM INTERFACE ======");
        System.out.println("1. Withdraw Money");
        System.out.println("2. Deposit Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Run ATM operations
    public void start() {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("💰 Current Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(5000.0);

        // Create ATM and connect it to the bank account
        ATM atm = new ATM(userAccount);

        // Start ATM
        atm.start();
    }
}

