class Customer {
    private String name;
    private ArrayList<Account> accounts;
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public void openAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accounts.add(account);
    }
    public void viewAccounts() {
        System.out.println("Accounts for Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
        }
    }
    public void viewBalance(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Balance for Account " + accountNumber + ": " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
public class BankAndAccounts {
    public static void main(String[] args) {


        Bank bank = new Bank("National Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);




        bank.openAccount(customer1, "12345", 1000.00);
        bank.openAccount(customer1, "12346", 500.00);
        bank.openAccount(customer2, "54321", 1500.00);




        bank.viewCustomers();




        customer1.viewAccounts();
        customer2.viewAccounts();


        customer1.viewBalance("12345");


        customer1.viewBalance("12345");
        customer1.openAccount("12347", 3000.00);
        customer1.viewBalance("12347");
    }
}
