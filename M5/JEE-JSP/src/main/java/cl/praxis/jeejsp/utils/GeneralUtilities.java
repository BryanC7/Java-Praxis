package cl.praxis.jeejsp.utils;

public class GeneralUtilities {
    public int calculateFibonacci(int number) {
        int factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public String calculatePairOdd(int number) {
        if(number % 2 == 0) {
            return "par";
        } else {
            return "impar";
        }
    }
}
