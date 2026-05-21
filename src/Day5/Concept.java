package Day5;

public class Concept {

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        System.out.println(c1.id);
        System.out.println(c2.id);

        System.out.println(Counter.count); // static variables can be accessed using class name

//        Static methods => MathHelper class // directly call the class
        //Java mein already dekha hai: Math.sqrt(), Math.abs(), Arrays.sort() — sab static methods hain.

        int sq = MathHelper.square(2);
        System.out.println(sq);

        System.out.println();

        Example e = new Example();
        e.instanceMethod();


        System.out.println("Bank Account");

        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount();

        b1.deposit(10);

        System.out.println(b1.getBalance() + " current balance");

        b1.withdraw(5);

        System.out.println(b1.getBalance() + " updated balance");
        System.out.println(BankAccount.getTotalAccounts());

        System.out.println();
        System.out.println("MathHelper1 Implementation");
        System.out.println();

        System.out.println(MathHelper1.factorial(5));
        System.out.println(MathHelper1.fibonacci(5));
        System.out.println(MathHelper1.isPrime(5));


        System.out.println();
        System.out.println("App Config");
        System.out.println();
//        AppConfig config = new AppConfig();


        AppConfig app1 = AppConfig.getInstance();
        AppConfig app2 = AppConfig.getInstance();
        System.out.println(app1 == app2);

        System.out.println(app1.getAppName());
        app1.setAppName("INJ");
        System.out.println(app1.getAppName());

        System.out.println(app2.getAppName() +  " app2 name");




    }
}
