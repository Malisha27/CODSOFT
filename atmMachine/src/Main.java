import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }

        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
        return true;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            displayOptions();
            System.out.print("Choose an option (1-4): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawalAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Current balance: " + userAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }

        } while (option != 4);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM and connect it to the user's BankAccount
        ATM atm = new ATM(userAccount);

        // Process user input using the ATM
        atm.processUserInput();
    }
}
