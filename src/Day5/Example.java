package Day5;

public class Example {
    int x = 10;
    static int y = 20;

     void instanceMethod () {
        System.out.println(this.x);
        System.out.println(this.y); // will throw error
        System.out.println(y); // this is fine
    }


    static void staticMethod () {
        System.out.println(y);
//        System.out.println(x); // Error : Non-static field 'x' cannot be referenced from a static context

    }
}
