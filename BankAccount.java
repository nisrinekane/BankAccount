import java.text.DecimalFormat;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int accountsCount = 0;
    private static double totalAmount = 0;

    // bank account constructor
    public BankAccount() {
        accountsCount++;
        this.accountNumber = getAccountNumber();
    }

    // Random Account Number Generator
    public String getAccountNumber() {
        String accountNumber = "";

        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random()*10);
            accountNumber += random;
        }

        return accountNumber;
    }

    // getter methods for checking and savings accounts
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    // deposit
    public void deposit(String accountType, double amount) {
        if (accountType == "checking") {
            this.checkingBalance += amount;
        } else if (accountType == "savings") {
            this.savingsBalance += amount;
        } else {
            System.out.println("Incorrect account type.");
        }

        totalAmount += amount;
    }


    //  withdrawal
    public void withdraw(String accountType, double amount) {
        if (accountType == "checking") {
            if (amount > this.checkingBalance) {
                System.out.println("Insufficient funds.");
            } else {
                this.checkingBalance -= amount;
                totalAmount -= amount;
                System.out.println("Withdrew $" +amount + " from your checking account.");
            }
        } else if (accountType == "savings") {
            if (amount > this.savingsBalance) {
                System.out.println("Insufficient funds.");
            } else {
                this.checkingBalance -= amount;
                totalAmount -= amount;
                System.out.println("Withdrew $" + amount + " from your savings account.");
            }
        } else {
            System.out.println("Incorrect account type.");
        }
    }


    // total of checking and saving
    public void getBalances() {
        System.out.println("Checking account: $" + getCheckingBalance());
        System.out.println("Savings account: $" + getSavingsBalance());
    }


}