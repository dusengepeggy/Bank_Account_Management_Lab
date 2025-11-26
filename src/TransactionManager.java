import java.util.Arrays;

public class TransactionManager {
    private Transaction[] transactions = new Transaction[200];
    private int transactionCount;

    void addTransaction (Transaction transaction){
        transactions[transactionCount]=transaction;
        transactionCount++;

    }
    Transaction[] filterById (String id){
        return Arrays.stream(transactions)
                .filter(ele-> ele.getAccountNumber()
                        .equals(id)).toArray(Transaction[]::new);
    }
    void viewTransactionsByAccounts ( String accountNumber ) {
        Transaction[] transactionsByAccountId = filterById( accountNumber );
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
