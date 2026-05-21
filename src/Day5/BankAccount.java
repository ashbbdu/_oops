package Day5;

public class BankAccount {
   private static int totalAccounts;
   private double balance;

    BankAccount () {
        totalAccounts++;
    }

    static int getTotalAccounts () {
        return totalAccounts;
    }

    void deposit (double amount) {
       if(amount > 0) {
           balance+=amount;
       } else {
           System.out.println("Please enter a valid amount !");
       }
    }

    void withdraw (double amount) {
        if( amount > 0 && amount <= balance ) {
            balance-=amount;
        } else {
            System.out.println("Insufficient balance !");
        }
    }

    double getBalance () {
        return balance;
    }




}
