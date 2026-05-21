package Day5;

public class MathHelper1 {
    static long factorial(int n) {
        if (n < 0)
            return -1;

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static int fibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int a = 0, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
