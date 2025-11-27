import java.util.Arrays;

public class AccountManager {
   private Account[] accounts = new Account[50];
   private int accountCount;
   void addAccount (Account newAccount){
       accounts[accountCount]=newAccount;
       accountCount++;
   }
   Account findAccount (String accountNumber){

       for (int i = 0; i < accountCount ; i++) {
           if (accounts[i].getAccountNumber().equals(accountNumber)){
               return accounts[i];
           }

       }
       return null;
   }

   void viewAllAccounts (){
       for (int i=0 ; i<accountCount;i++){
           accounts[i].displayAccountDetail();
       }
   }

   double getTotalBalance () {
       double sum = 0;
       for (int i=0 ; i<accountCount;i++){
           sum += accounts[i].getBalance();
       }
       return sum;
   }

   int getAccountCount(){
       return accountCount;
   }

}
