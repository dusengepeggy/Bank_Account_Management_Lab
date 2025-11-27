public class CheckingAccount extends Account {
    private double overdraftLimit, monthlyFee;

    public CheckingAccount(Customer customer, double balance, String status) {
        super( customer, balance, status);
        this.overdraftLimit = 1000;
        this.monthlyFee = 10;
    }
    @Override
    String getAccountType() {
        return "Checking";
    }
    @Override
    void displayAccountDetail() {
        System.out.println("Account details");
        System.out.println("____________________");
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Account holder name: " + getCustomer().getName()+ " ("+ getCustomer().getCustomerType() +")");
        System.out.println("Account status: " + getStatus());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account Balance: $" + getBalance() );
        System.out.println("Overdraft limit: $" + overdraftLimit);
        System.out.println("Monthly fee: " + monthlyFee);
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        double newBalance = getBalance() - amount;
        if (newBalance < -overdraftLimit) {
            System.out.println("Withdrawal denied: exceeds overdraft limit of " + overdraftLimit);
            return false;
        }
        setBalance(newBalance);
        return true;
    }

    void applyMontlhyFee(){
        double balance = getBalance();
        setBalance(balance-=monthlyFee);
    }
}
