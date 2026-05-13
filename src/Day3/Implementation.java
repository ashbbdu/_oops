package Day3;

public class Implementation {
    public static void main(String[] args) {
        Car c = new Car("BMW" , 200);
        System.out.println(c.brandName);


        Book b1 = new Book();
        b1.display();

        Book b2 = new Book("How to master the art of making money" , "Ashish Srivastava" , 400.00);
        b2.display();

        Employee e1 = new Employee(1 , "Ashish Srivastava" , 2100000000000.00);
        e1.display();



        Point p = new Point(10 , 10);
        p.distanceFromOrigin();
        p.distanceTo(p);
    }
}
