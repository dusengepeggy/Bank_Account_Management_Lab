public class RegularCustomer extends Customer {
    public RegularCustomer(String name, int age, String contact, String address) {
        super( name, age, contact, address);
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
    }

    @Override
    public String getCustomerType() {
        return "Regular";
    }
}
