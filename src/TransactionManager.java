import java.util.Arrays;

public class TransactionManager {
    private Transaction[] transactions = new Transaction[200];
    private int transactionCount;

    void addTransaction (Transaction transaction){
        transactions[transactionCount]=transaction;
        transactionCount++;

    }
    Transaction[] filterById(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return new Transaction[0];
        }

        Transaction[] temp = new Transaction[transactionCount];
        int count = 0;

        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i].getAccountNumber().equals(accountNumber)) {
                temp[count] = transactions[i];
                count++;
            }
        }

        return temp;
    }
    void viewTransactionsByAccounts ( String accountNumber ) {
        Transaction[] transactionsByAccountId = filterById( accountNumber );
        if (transactionsByAccountId.length == 0 ){
            System.out.println("No transactions yet");
            return;

        }
        for (Transaction transaction: transactionsByAccountId ){
            transaction.displayTransactionDetails();
        }
    }

    void calculateDeposits ( String accountNumber ) {
        double depositSum = 0;
        Transaction[] transactionsByAccountId = filterById(accountNumber);
        for (Transaction transaction: transactionsByAccountId ){
            if(transaction.getType().equals("Deposit")){
                depositSum+= transaction.getAmount();
            }

        }

    }

    void calculateWithdrawal ( String accountNumber ) {
        double withdrawnSum = 0;
        Transaction[] transactionsByAccountId = filterById(accountNumber);
        for (Transaction transaction: transactionsByAccountId ){
            if(transaction.getType().equals("Withdrawal")){
                withdrawnSum += transaction.getAmount();
            }

        }

    }
    int getTransactionCount () {
        return transactionCount;
    }

}
