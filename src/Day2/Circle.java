package Day2;

public class Circle {
    public int radius;

    public double area () {
        return Math.PI * (radius * radius);
    }

    public double circumference () {
        return  2 * Math.PI * radius;
    }
}
