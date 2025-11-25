public class SavingsAccount extends Account {
    private double interestRate ;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, Customer customer, double balance, String status) {
        super(accountNumber, customer, balance, status);
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

        



    }


}
