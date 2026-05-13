package Day3;

public class Implementation {
    public static void main(String[] args) {
        Car c = new Car("BMW" , 200);
        System.out.println(c.brandName);


        Book b1 = new Book();
        b1.display();

        Book b2 = new Book("How to master the art of making money" , "Ashish Srivastava" , 400.00);
        b2.display();
    }
}
