package Day2;

public class Implementation {
    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        mo.greet("Ashish");
        mo.greet("Ashish" , "Good Evening");

        Circle c = new Circle();
        c.radius = 7;
        System.out.println(c.area());
        System.out.println(c.circumference());

        Temperature t = new Temperature();
        System.out.println(t.celsiusToFahrenheit(10));
        System.out.println(t.fahrenheitToCelsius(10));


        String test = "test";
        StringHelper s = new StringHelper();
        System.out.println(s.reverseString(test));
        System.out.println(s.isPalindrome(test));
        System.out.println(s.countVowels(test));
    }
}
