package models;

/**
 * Abstract base class representing a bank account that implements transaction capabilities.
 * Provides common account functionality and defines abstract methods for account-specific behavior.
 */
public abstract class Account implements Transactable {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;
    static int accountCounter;

    /**
     * Constructs a new Account with the specified customer, balance, and status.
     *
     * @param customer the customer who owns this account
     * @param balance the initial balance of the account
     * @param status the status of the account
     */
    public Account(Customer customer, double balance, String status) {
        this.accountNumber = "ACC" + String.format("%03d", accountCounter + 1);
        this.customer = customer;
        this.balance = balance;
        this.status = status;
        accountCounter++;
    }

    /**
     * Returns the account number.
     *
     * @return the account number as a String
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the account number to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the customer associated with this account.
     *
     * @return the customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with this account.
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the status of the account.
     *
     * @return the account status as a String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the account.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the total number of accounts created.
     *
     * @return the account counter value
     */
    public static int getAccountCounter() {
        return accountCounter;
    }

    /**
     * Sets the account counter to the specified value.
     *
     * @param accountCounter the counter value to set
     */
    public static void setAccountCounter(int accountCounter) {
        Account.accountCounter = accountCounter;
    }

    /**
     * Displays the account details. Implementation is provided by subclasses.
     */
    abstract public void displayAccountDetail();

    /**
     * Returns the type of account. Implementation is provided by subclasses.
     *
     * @return the account type as a String
     */
    abstract public String getAccountType();

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to deposit
     */
    void deposit(double amount) {
        updateBalance(amount);
    }

    /**
     * Withdraws the specified amount from the account.
     * Implementation is provided by subclasses with account-specific rules.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal is successful, false otherwise
     */
    abstract boolean withdraw(double amount);

    /**
     * Processes a transaction (deposit or withdrawal) on this account.
     *
     * @param amount the transaction amount
     * @param type the transaction type ("DEPOSIT" or "WITHDRAWAL")
     * @return true if the transaction was successful, false otherwise
     */
    @Override
    public boolean processTransaction(double amount, String type) {
        if ("DEPOSIT".equalsIgnoreCase(type)) {
            return processDeposit(amount);
        } else if ("WITHDRAWAL".equalsIgnoreCase(type)) {
            return processWithdrawal(amount);
        }
        return false;
    }

    /**
     * Validates that the account has sufficient balance for a withdrawal.
     *
     * @param amount the amount to withdraw
     * @return true if balance is sufficient, false otherwise
     */
    protected boolean validateBalance(double amount) {
        return balance >= amount;
    }

    /**
     * Updates the account balance by adding the specified amount.
     *
     * @param amount the amount to add to the balance
     */
    protected void updateBalance(double amount) {
        balance += amount;
    }

    /**
     * Processes a deposit transaction.
     *
     * @param amount the amount to deposit
     * @return true if deposit is successful, false otherwise
     */
    private boolean processDeposit(double amount) {
        try {
            deposit(amount);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Processes a withdrawal transaction.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal is successful, false otherwise
     */
    private boolean processWithdrawal(double amount) {
        return withdraw(amount);
    }
}
