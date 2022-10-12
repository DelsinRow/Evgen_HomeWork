import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        int userStep;

        System.out.println();
        System.out.print("First ten numbers of Fibonacci: ");
        printNumberOfFibonacci(10);

        System.out.println();
        System.out.print("Please enter Fibonacci's number: ");
        userStep = inputFibonacciNumber() - 1;
        System.out.println(findFibonacciNumber(userStep));

    }

    public static int inputFibonacciNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterSize = String.valueOf(reader.readLine());
        while (!isDigit(enterSize)) {
            System.out.println("It's not a number. Try again: ");
            enterSize = String.valueOf(reader.readLine());
        }
        return parseInt(enterSize);
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printNumberOfFibonacci(int n){
        int number = 0;
        int abs = 0;
        for (int i = 0, j = 1; i < n; i++){
            System.out.print(number + " ");
            abs = number;
            number = number + j;
            j = abs;
        }

    }

    private static int findFibonacciNumber(int n){
        if (n == 0){return 0;}
        if (n == 1){return 1;}
//        if (n == 2){return 1;}
        else{
            return findFibonacciNumber(n - 1) + findFibonacciNumber(n - 2);
        }
    }
}

