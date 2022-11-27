package simpletask; /**
 * Без рекурсии
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BinaryArray {
    public static void main(String[] args) throws IOException {
        int[] binaryArray = {1, 2, 5, 3, 88, 55, 64};
        Arrays.sort(binaryArray);
        System.out.print("Your sort's array: ");
        printArray(binaryArray);
        System.out.println();

        System.out.print("What number are you looking for? Please enter it: ");
        int inputNumber = enterNumber();
        findNumber(binaryArray, inputNumber);


    }
    // сам метод
    public static void findNumber(int[] array, int number){
            int l = 0;                                          //левый индекс
            int r = array.length - 1;                           //правый индекс
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (array[mid] == number) { System.out.println(
                        "Your number is present in the array under the index = " + mid);
                }
                if (number < array[mid]) { r = mid - 1; }
                else { l = mid + 1; }
            }

        }


    //ввод числа
    public static int enterNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterSize = String.valueOf(reader.readLine());
        while (!isDigit(enterSize)) {
            System.out.println("It's not a number. Try again: ");
            enterSize = String.valueOf(reader.readLine());
        }
        return parseInt(enterSize);
    }
    //проверка
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //вывод массива
    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
        }
    }

}