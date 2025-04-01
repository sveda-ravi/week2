interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;


    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }


    public String getHolderName() {
        return holderName;
    }


    public double getBalance() {
        return balance;
    }


    protected void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("$%.2f deposited. New Balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("$%.2f withdrawn. New Balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public abstract double calculateInterest();


    public void displayAccountDetails() {
        System.out.println("Account #: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.printf("Balance: $%.2f\n", balance);
    }
}
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }


    public double calculateInterest() {
        return getBalance() * 0.04;
    }


    public void applyForLoan(double amount) {
        System.out.printf("Savings loan of $%.2f applied for.\n", amount);
    }


    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}


class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }


    public double calculateInterest() {
        return getBalance() * 0.01;
    }


    public void applyForLoan(double amount) {
        System.out.printf("Current account loan of $%.2f applied for.\n", amount);
    }


    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}


public class BankingSystem1 {
    public static void processAccounts(BankAccount[] accounts) {
        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();


            double interest = acc.calculateInterest();
            System.out.printf("Interest Earned: $%.2f\n", interest);


            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(1000);
                System.out.printf("Loan Eligibility: $%.2f\n", loanAcc.calculateLoanEligibility());
            }


            System.out.println("-----------------------------");
        }
    }


    public static void main(String[] args) {
        BankAccount[] customers = {
                new SavingsAccount("SAV123", "Alice", 5000),
                new CurrentAccount("CUR456", "Bob", 3000)
        };


        customers[0].deposit(1000);
        customers[1].withdraw(500);


        processAccounts(customers);
    }
}
