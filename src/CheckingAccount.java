public class CheckingAccount extends Account {
    private double overdraftLimit, monthlyFee;

    public CheckingAccount(String accountNumber, Customer customer, double balance, String status) {
        super(accountNumber, customer, balance, status);
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
        System.out.println("Account holder name: " + getCustomer().getName());
        System.out.println("Account status: " + getStatus());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account Balance: " + getBalance() );
        System.out.println("Overdraft limit: " + overdraftLimit);
        System.out.println("Monthly fee: " + monthlyFee);
    }
    @Override
    void withdraw (double amount){
        if (getBalance()-amount>overdraftLimit) {
            System.out.println("You cannot withdraw");
        }
        else {
            super.withdraw(amount);
        }
    }
    void applyMontlhyFee(){
        double balance = getBalance();
        setBalance(balance-=monthlyFee);
    }
}
