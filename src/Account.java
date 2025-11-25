public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;
    static int accountCounter;

    public Account() {
    }

    public Account(String accountNumber, Customer customer, double balance, String status) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public static void setAccountCounter(int accountCounter) {
        Account.accountCounter = accountCounter;
    }

    abstract void displayAccountDetail();
    abstract String getAccountType();

    void deposit ( double amount ){
        balance+=amount;
    }
    void withdraw ( double amount ){
        balance-=amount;
    }

}
