public class SavingsAccount extends Account {
    private double interestRate ;
    private double minimumBalance;

    public SavingsAccount(Customer customer, double balance, String status) {
        super( customer, balance, status);
        this.interestRate = 3.5/100;
        this.minimumBalance = 500;
    }
    @Override
    String getAccountType() {
        return "Savings";

    }
    @Override
    void displayAccountDetail() {
        System.out.println("Account details");
        System.out.println("____________________");
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Account holder name: " + getCustomer().getName());
        System.out.println("Account status: " + getStatus());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account Balance: " + getBalance() );
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
