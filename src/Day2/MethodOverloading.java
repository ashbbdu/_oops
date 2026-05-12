package Day2;

public class MethodOverloading {
    public void greet (String name) {
        System.out.println("Good Morning : " + name);
    }

    public void greet(String name , String daytime) {
        System.out.println(daytime + " : " + name);
    }
}
