package Day1;

public class Implementation {
    public static void main(String[] args) {
        Car audi = new Car();
        Car bmw = new Car();
        audi.accelerate();

        audi.brandName = "Audi";
        bmw.brandName = "BMW";

        System.out.println(audi.brandName);
        System.out.println(bmw.brandName);
        System.out.println(bmw.topSpeed);


//        Bank Account
        BankAccount hdfc = new BankAccount();
        hdfc.accountHolder = "Priyanka Srivastava";
        hdfc.balance = 1000000000;

        hdfc.showBalance();

        Rectangle r1 = new Rectangle();
        r1.length = 4;
        r1.width = 6;
        r1.area();
        r1.perimeter();

        Phone apple = new Phone();
        apple.brand = "Apple";
        apple.model = "Iphone 17 Pro Max";
        apple.price = 150000;

        apple.describe();
    }
}
