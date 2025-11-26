import java.util.Arrays;

public class AccountManager {
   private Account[] accounts = new Account[50];
   private int accountCount;
   void addAccount (Account newAccount){
       accounts[accountCount]=newAccount;
       accountCount++;
   }
   void findAccount (String accountNumber){
       for (Account account:accounts) {
           if (account.getAccountNumber().equals(accountNumber)){
               System.out.println("Account details");
               account.displayAccountDetail();
               break;
           }

       }
       System.out.println("There was no Account found with the specified number");

   }

   void viewAllAccounts (){
       for (Account account:accounts){
           account.displayAccountDetail();
       }
   }

   double getTotalBalance () {
       double sum = 0;
       for (Account account:accounts){
           sum += account.getBalance();
       }
       return sum;
   }

   int getAccountCount(){
       return accountCount;
   }

}
