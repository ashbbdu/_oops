package Day3;

public class Rectangle {
    int length , width;


    Rectangle () {
        this(1,2); // constructor chaining calling another constructor from another constructor
    }

    Rectangle (int length , int width) {
        this.length = length;
        this.width = width;
    }
}
