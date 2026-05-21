package Day4;

public class Implementation {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("ashish");
        System.out.println(p1.getName());

        p1.setAge(0);

        System.out.println(p1.getAge());

        System.out.println();
        System.out.println("********* Bank Account **********");
        System.out.println();
        BankAccount bank1 = new BankAccount("Test" , 100);
        bank1.deposit(10);
        System.out.println(bank1.getBalance());

        bank1.withdraw(8);
        System.out.println(bank1.getBalance());
        bank1.display();
    }
}
