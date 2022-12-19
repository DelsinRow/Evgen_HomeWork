package leetcode.Polindrome;

import java.util.ArrayList;
import java.util.List;

public class Polindrome {
    static Integer x = 101;

    public static void main(String[] args) {
        System.out.println(new Polindrome().isPalindrome(x));

    }
    public boolean isPalindrome(Integer x) {
        if (x < 0) return false;
        StringBuilder s = new StringBuilder();
        int xa = x;
        List<Integer> polinromList = new ArrayList<>();
        while (!(xa/10 == 0)) {
            int value;

            value = xa%10;
            polinromList.add(value);
            xa = xa/10;
            System.out.println(polinromList);
        }
        polinromList.add(xa);
        System.out.println(polinromList);
        System.out.println(x);

        for (int digits : polinromList) {
//            String digit = null;
//            digit = String.valueOf(digits);
            s.append(digits);
        }
        String first = String.valueOf(s);
        String second = String.valueOf(x);

        System.out.println("first = " + first + first.getClass());
        System.out.println("second = " + second + second.getClass());
        return first.equals(second);

    }
}
