import java.util.Scanner;

// Base class Account
class Account {
    String customerName;
    String accountNumber;
    double balance;
    String accountType;

    // Constructor to initialize the Account details
    public Account(String name, String accNo, String type) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = 0.0;
    }

    // Method to accept deposit and update balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to display the balance
    public void displayBalance() {
        System.out.println("Balance in account " + accountNumber + ": " + balance);
    }

    // Method to permit withdrawal and update balance
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Class for Savings Account derived from Account
class SavAcct extends Account {

    // Constructor for Savings Account
    public SavAcct(String name, String accNo) {
        super(name, accNo, "Savings");
    }

    // Method to compute and deposit interest (compound interest)
    public void computeAndDepositInterest(double rate, int time) {
        double interest = balance * Math.pow(1 + rate / 100, time) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " deposited to your account.");
    }
}

// Class for Current Account derived from Account
class CurAcct extends Account {
    double minimumBalance;
    double serviceCharge;

    // Constructor for Current Account
    public CurAcct(String name, String accNo, double minBalance) {
        super(name, accNo, "Current");
        minimumBalance = minBalance;
        serviceCharge = 50.0; // Assume service charge is 50 units if balance falls below minimum
    }

    // Method to check minimum balance, impose penalty if necessary
    public void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance is below minimum required. Service charge of " + serviceCharge + " imposed.");
        }
    }
}

// Main class to test the Bank System
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account;
        
        // Create a new account (example)
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        
        System.out.println("Enter account type (1 for Savings, 2 for Current): ");
        int accType = sc.nextInt();
        
        // Create account based on type
        if (accType == 1) {
            account = new SavAcct(name, accNo);
        } else if (accType == 2) {
            System.out.print("Enter Minimum Balance for Current Account: ");
            double minBalance = sc.nextDouble();
            account = new CurAcct(name, accNo, minBalance);
        } else {
            System.out.println("Invalid account type. Exiting...");
            return;
        }

        // Perform operations on the account
        int option;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute and Deposit Interest");
            }
            if (account instanceof CurAcct) {
                System.out.println("4. Check Minimum Balance");
            }
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        System.out.print("Enter annual interest rate: ");
                        double rate = sc.nextDouble();
                        System.out.print("Enter time in years: ");
                        int time = sc.nextInt();
                        ((SavAcct) account).computeAndDepositInterest(rate, time);
                    } else if (account instanceof CurAcct) {
                        ((CurAcct) account).checkMinimumBalance();
                    }
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our banking services.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (option != 5);
    }
}
