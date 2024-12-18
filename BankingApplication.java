
import java.util.*;

class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private double dailyWithdrawalLimit;
    private double withdrawnToday;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit, double dailyWithdrawalLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.withdrawnToday = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else if (withdrawnToday + amount > dailyWithdrawalLimit) {
                System.out.println("Withdrawal limit exceeded. Daily limit: " + dailyWithdrawalLimit);
            } else {
                balance -= amount;
                withdrawnToday += amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Daily Withdrawal Limit: " + dailyWithdrawalLimit);
    }
}

public class BankingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\nBanking Application");
            System.out.println("1. Create Account\n2. Deposit Money\n3. Withdraw Money\n4. Check Balance\n5. Display Account Information\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    System.out.print("Enter daily withdrawal limit: ");
                    double dailyWithdrawalLimit = scanner.nextDouble();
                    account = new BankAccount(accountNumber, accountHolderName, initialDeposit, dailyWithdrawalLimit);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        System.out.println("Current balance: " + account.checkBalance());
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 5:
                    if (account != null) {
                        account.displayAccountInfo();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
