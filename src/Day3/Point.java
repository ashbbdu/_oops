package Day3;

public class Point {
    int x;
    int y;

    Point () {
        this.x = 0;
        this.y = 0;
    }

    Point (int x , int y) {
        this.x = x;
        this.y = y;
    }

    void distanceFromOrigin () {
        System.out.println(Math.sqrt(x*x + y*y));
    }

    void distanceTo(Point other) {
        System.out.println(Math.sqrt((x-other.x)*(x-other.x) + (y-other.y)*(y-other.y)));
    }
}
