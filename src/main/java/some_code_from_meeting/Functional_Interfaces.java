package some_code_from_meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * Predicate<a> - <a> - на вход, boolean на выход
 * Consumer<a> - <a> - на вход, void - на выход
 * Function<a,b> - <a> - на вход, <b> - на выход
 * Supplier<a> - () на вход, <a> - на выход
 * UnaryOperator<a> - <a> - на вход, <a> - на выход
 * BinaryOperator<a> - x<a>, y<a> - на вход, <a>, <a> - на выход
 *
 * stream methods:
 * lazy & eager методы
 * filter() - фильтрация
 * collect() - преобразование в другую коллекцию
 * map() - превращает одни объекты в другие
 * flatMap() - преобразует [][] -> [], в последовательность
 * district(index) - до
 * skip(index) - после
 *
 * optional - ?
 */




public class Functional_Interfaces {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("world");
        stringList.add("cat");
        stringList.add("Denis");
        stringList.add("dog");
        stringList.add("Valentina");
        stringList.add("Ekaterina");
        stringList.add("Evgenii");
        stringList.add("function");

        Predicate<String> predicate = word -> Character.isUpperCase(word.charAt(0));
        Predicate<String> predicate1 = word -> word.length() > 5;
        Predicate<String> predicate2 = word -> word.startsWith("D");


        for (String word : stringList) {
            System.out.println(predicate.and(predicate1.or(predicate2)).test(word));

        }


    }
}
