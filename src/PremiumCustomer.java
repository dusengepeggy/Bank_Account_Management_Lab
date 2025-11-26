public class PremiumCustomer extends Customer {
    private double minimumBalance;
    public PremiumCustomer(String customerId, String name, int age, String contact, String address) {
        super(customerId, name, age, contact, address);
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void displayCustomerDetails() {
        System.out.println("Customer details");
        System.out.println("____________________");
        System.out.println("Customer number: " + getCustomerId());
        System.out.println("Customer holder name: " + getName());
        System.out.println("Customer age: " + getAge());
        System.out.println("Customer contacts: " + getContact());
        System.out.println("Customer Address: " + getAddress() );
        System.out.println("Premium benefits; " + "Premium customers don't pay monthly fees");
    }

    @Override
    public String getCustomerType() {
        return "Premium";
    }

    boolean hasWaivedFees (){
        return true;
    }
}
