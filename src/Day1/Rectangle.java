package Day1;

public class Rectangle {
    int length;
    int width;

    void area () {
        System.out.println("Area of this rectangle is : " + length * width);
    }

    void  perimeter () {
        System.out.println("Perimeter of this rectangle is : " + 2*(length + width));
    }
}
