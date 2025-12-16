package models;

import models.exceptions.InvalidAmountException;
import models.exceptions.OverdraftExceededException;

public class CheckingAccount extends Account {
    private double overdraftLimit, monthlyFee;

    public CheckingAccount(Customer customer, double balance, String status) {
        super( customer, balance, status);
        this.overdraftLimit = 1000;
        this.monthlyFee = 10;
    }
    @Override
    public String getAccountType() {
        return "Checking";
    }
    @Override
    public void displayAccountDetail() {
        System.out.println("models.Account details");
        System.out.println("____________________");
        System.out.println("models.Account number: " + getAccountNumber());
        System.out.println("models.Account holder name: " + getCustomer().getName()+ " ("+ getCustomer().getCustomerType() +")");
        System.out.println("models.Account status: " + getStatus());
        System.out.println("models.Account Type: " + getAccountType());
        System.out.println("models.Account Balance: $" + getBalance() );
        System.out.println("Overdraft limit: $" + overdraftLimit);
        System.out.println("Monthly fee: " + monthlyFee);
    }
    @Override
    public void withdraw(double amount) throws InvalidAmountException, OverdraftExceededException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        double newBalance = getBalance() - amount;
        if (newBalance < -overdraftLimit) {
            throw new OverdraftExceededException(getBalance(), amount, overdraftLimit);
        }
        setBalance(newBalance);
    }

    void applyMontlhyFee(){
        double balance = getBalance();
        setBalance(balance-=monthlyFee);
    }
}
