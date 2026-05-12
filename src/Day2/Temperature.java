package Day2;

public class Temperature {
    public double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

}
