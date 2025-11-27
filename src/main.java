import java.util.Scanner;

public class main {
    private static AccountManager accountManager = new AccountManager();
    private static TransactionManager transactionManager = new TransactionManager();
    private static Scanner sc = new Scanner(System.in);

    //...........................Sample customer data........................................
    private static void initializeSampleData() {
        Customer c1 = new RegularCustomer("John Smith", 35, "+1-555-0001", "123 Main St");
        Account a1 = new SavingsAccount(c1, 5250.00,"Active");
        accountManager.addAccount(a1);

        Customer c2 = new RegularCustomer("Sarah Johnson", 28, "+1-555-0002", "456 Oak Ave");
        Account a2 = new CheckingAccount(c2, 3450.00,"Active");
        accountManager.addAccount(a2);

        Customer c3 = new PremiumCustomer("Michael Chen", 42, "+1-555-0003", "789 Pine Rd");
        Account a3 = new SavingsAccount(c3, 15750.00,"Active");
        accountManager.addAccount(a3);

        Customer c4 = new RegularCustomer("Emily Brown", 31, "+1-555-0004", "321 Elm St");
        Account a4 = new CheckingAccount(c4, 890.00,"Active");
        accountManager.addAccount(a4);

        Customer c5 = new PremiumCustomer("David Wilson", 55, "+1-555-0005", "654 Maple Dr");
        Account a5 = new SavingsAccount(c5, 25300.00,"Active");
        accountManager.addAccount(a5);
    }

    //...........................main method..................
    public static void main (String[] args){
        initializeSampleData();
        while (true) {

            System.out.println("=======================================\n  BANK ACCOUNT MANAGEMENT - MAIN MENU \n=======================================");
            System.out.println(" \t1. Create Account \n \t2. View Accounts \n \t3. Process Transaction \n \t4. View Transation History \n\t5. Exit");
            System.out.println("\nEnter choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    processTransaction();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thanks bye");
                    return;
                default:
                    System.out.println("choose correctly");
                    continue;
            }
        }

    }


    //........reusable press enter to continue.........................
    private static void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }
    // ------------------- Input Validators -------------------
    private static int readInt(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value >= min && value <= max) return value;
                System.out.println("Input must be between " + min + " and " + max + "!");
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
    }

    private static double readDouble(String prompt, double min) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();
                if (value >= min) return value;
                System.out.println("Amount must be at least $" + min);
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty!");
        }
    }

    //......................menu actions................................
    private static void createAccount() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ACCOUNT CREATION");
        System.out.println("=".repeat(50));
        System.out.println();

        String name = readNonEmptyString("Enter customer name: ");
        int age = readInt("Enter customer age: ", 1, 120);
        String contact = readNonEmptyString("Enter customer contact: ");
        String address = readNonEmptyString("Enter customer address: ");

        System.out.println("\nCustomer type:");
        System.out.println("1. Regular Customer (Standard banking services)");
        System.out.println("2. Premium Customer (Enhanced benefits, min balance $10,000)");
        int customerType = readInt("\nSelect type (1-Regular, 2-Premium): ", 1, 2);

        Customer customer;
        if (customerType == 1) {
            customer = new RegularCustomer(name, age, contact, address);
        } else {
            customer = new PremiumCustomer(name, age, contact, address);
        }

        System.out.println("\nAccount type:");
        System.out.println("1. Savings Account (Interest: 3.5%, Min Balance: $500)");
        System.out.println("2. Checking Account (Overdraft: $1,000, Monthly Fee: $10)");
        int accountType = readInt("\nSelect account type (1-Savings, 2-Checking): ", 1, 2);

        double minDeposit = (customerType==1) ? 500 : (customerType == 2 && accountType == 1) ? 10000 : 0;
        double initialDeposit = readDouble("Enter initial deposit amount: $", minDeposit);

        Account account;
        if (accountType == 1) {
            account = new SavingsAccount(customer, initialDeposit,"Active");
        } else {
            account = new CheckingAccount(customer, initialDeposit, "Active");
        }

        accountManager.addAccount(account);
        account.displayAccountDetail();
        System.out.println("\n✓ Account created successfully!");
        pressEnterToContinue();
    }

    private static void viewAccounts() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ACCOUNT LISTING");
        System.out.println("=".repeat(50));
        System.out.println();

        accountManager.viewAllAccounts();

        System.out.println("\nTotal Accounts: " + accountManager.getAccountCount());
        System.out.println("Total Bank Balance: $" + accountManager.getTotalBalance());

        pressEnterToContinue();
    }

    private static void processTransaction() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("PROCESS TRANSACTION");
        System.out.println("=".repeat(50));
        System.out.println();

        String accountNumber = readNonEmptyString("Enter Account Number: ");
        Account account = accountManager.findAccount(accountNumber);

        if (account == null) {
            System.out.println("\n✗ Account not found!");
            pressEnterToContinue();
            return;
        }

        System.out.println("\nAccount Details:");
        System.out.println("Customer: " + account.getCustomer().getName());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Current Balance: " + account.getBalance());

        System.out.println("\nTransaction type:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        int transType = readInt("Select Type: ", 1, 2);
        double amount;
        if (transType == 1) {
            amount = readDouble("Enter amount to deposit: $", 0);
        } else {
            amount = readDouble("Enter amount to withdraw: $", 0);
            if (amount > account.getBalance()) {
                System.out.println("Insufficient balance! Transaction cancelled.");
                pressEnterToContinue();
                return;
            }
        }
        sc.nextLine();
        String type = (transType == 1) ? "DEPOSIT" : "WITHDRAWAL";
        double previousBalance = account.getBalance();
        double newBalance =  (transType == 1) ? (previousBalance+amount) : (previousBalance-amount) ;

        // Show confirmation
        System.out.println("\n" + "-".repeat(50));
        System.out.println("TRANSACTION CONFIRMATION");
        System.out.println("-".repeat(50));

        Transaction transaction = new Transaction(accountNumber, type, amount, newBalance);
        System.out.println("\nTransaction ID: " + transaction.getTransactionId());
        System.out.println("Account: " + accountNumber);
        System.out.println("Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Date/Time: " + transaction.getTimestamp());

        System.out.print("\nConfirm transaction? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            boolean success = account.processTransaction(amount,type);
            if (success){
                transactionManager.addTransaction(transaction);
                System.out.println("\n✓ Transaction completed successfully!");
            }
            else {
                System.out.println("Transaction failed. Check balance/limits.");
            }

        } else {
            System.out.println("\n✗ Transaction cancelled.");
        }

        pressEnterToContinue();
    }

    private static void viewTransactionHistory() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("VIEW TRANSACTION HISTORY");
        System.out.println("=".repeat(50));
        System.out.println();

        System.out.print("Enter Account Number: ");
        String accountNumber = readNonEmptyString("Enter Account Number: ");

        Account account = accountManager.findAccount(accountNumber);
        if (account == null) {
            System.out.println("\n✗ Account not found!");
            pressEnterToContinue();
            return;
        }

        System.out.println("\nAccount: " + accountNumber + " - " + account.getCustomer().getName());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("TXN ID  | DATE/TIME   |    TYPE      |  AMOUNT     | BALANCE   ");
        transactionManager.viewTransactionsByAccounts(accountNumber);

        pressEnterToContinue();
    }

}
