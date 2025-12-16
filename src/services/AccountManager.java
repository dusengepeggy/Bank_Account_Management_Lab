package services;

import models.Account;

public class AccountManager {
   private Account[] accounts = new Account[50];
   private int accountCount;
   public void addAccount (Account newAccount){
       accounts[accountCount]=newAccount;
       accountCount++;
   }
   public Account findAccount (String accountNumber){

       for (int i = 0; i < accountCount ; i++) {
           if (accounts[i].getAccountNumber().equals(accountNumber)){
               return accounts[i];
           }

       }
       return null;
   }

   public void viewAllAccounts (){
       for (int i=0 ; i<accountCount;i++){
           accounts[i].displayAccountDetail();
       }
   }

   public double getTotalBalance () {
       double sum = 0;
       for (int i=0 ; i<accountCount;i++){
           sum += accounts[i].getBalance();
       }
       return sum;
   }

   public int getAccountCount(){
       return accountCount;
   }

}
