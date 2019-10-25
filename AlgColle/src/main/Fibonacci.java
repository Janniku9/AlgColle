package main;
public class Fibonacci {
    public static int getFibonacciMemo (int n) {
        int [] fib = new int [Math.max(3, n+1)];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = 0;
        }

        fib [1] = 1;
        fib [2] = 1;

        return recursiveFibonacci(fib, n);
    }

    public static int recursiveFibonacci (int [] fib, int n) {
        if (fib[n] == 0) {
            return recursiveFibonacci(fib, n - 1) + recursiveFibonacci(fib,n - 2);
        } else {
            return fib[n];
        }
    }

    public static int getFibonacciDynamic (int n) {
        int [] fib = new int[Math.max(3, n+1)];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i < n+1; i++) {
            fib [i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }
}
