// Parent class: MyBankAccount
class MyBankAccount {
    public String accountNumber;      // public variable
    protected String accountHolder;   // protected variable
    private double balance;           // private variable

    // Constructor
    public MyBankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: MySavingsAccount
class MySavingsAccount extends MyBankAccount {
    private double interestRate;

    // Constructor for MySavingsAccount
    public MySavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);  // call parent constructor
        this.interestRate = interestRate;
    }

    // Method to display savings account details
    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Number (public): " + accountNumber);      // accessing public member
        System.out.println("Savings Account Holder (protected): " + accountHolder);   // accessing protected member
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class to test
public class BankAccountManagement {
    public static void main(String[] args) {
        MyBankAccount account = new MyBankAccount("1234567890", "John Doe", 5000.00);
        account.displayAccountDetails();

        System.out.println();

        MySavingsAccount savings = new MySavingsAccount("9876543210", "Alice Smith", 10000.00, 3.5);
        savings.displaySavingsAccountDetails();

        // Using public getter to access private balance field
        System.out.println("Savings Account Balance (via getter): $" + savings.getBalance());

        // Updating balance using public setter
        savings.setBalance(12000.00);
        System.out.println("Updated Savings Account Balance: $" + savings.getBalance());
    }
}
