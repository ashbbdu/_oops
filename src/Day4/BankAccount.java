package Day4;

public class BankAccount {
    private String owner;
    private double balance;

    BankAccount (String owner , double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner () {
        return owner;
    }

    public double getBalance () {
        return balance;
    }


    public void deposit (double amount) {
        if(amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Amount should be greater than 0 !");
        }

    }

    public void withdraw (double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance");
        } else if (amount < 0) {
            System.out.println("Amount should be greater than 0 !");
        } else {
            balance -= amount;
        }
    }

    public void display () {
        System.out.println(this.owner + " " + this.balance);
    }

}
