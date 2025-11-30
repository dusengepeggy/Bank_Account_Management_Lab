package models;

public class SavingsAccount extends Account {
    private double interestRate ;
    private double minimumBalance;

    public SavingsAccount(Customer customer, double balance, String status) {
        super( customer, balance, status);
        this.interestRate = 3.5/100;
        this.minimumBalance = 500;
    }
    @Override
    public String getAccountType() {
        return "Savings";

    }
    @Override
    public void displayAccountDetail() {
        System.out.println("models.Account details");
        System.out.println("____________________");
        System.out.println("models.Account number: " + getAccountNumber());
        System.out.println("models.Account holder name: " + getCustomer().getName() + 1);
        System.out.println("models.Account status: " + getStatus());
        System.out.println("models.Account Type: " + getAccountType());
        System.out.println("models.Account Balance: " + getBalance() );
        System.out.println("Interest rate: "+ interestRate);
        System.out.println("Minimum balance: "+ minimumBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        double newBalance = this.getBalance()- amount;
        if (newBalance < minimumBalance) {
            System.out.println("Withdrawal denied: savings account must maintain minimum balance of " + minimumBalance);
            return false;
        }
        setBalance(newBalance);
        return true;
    }
    double calculateInterest(){
        double balance = getBalance();
        return balance*interestRate;
    }
}
