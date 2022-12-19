package coding_exercise_14;

import coding_exercise_13.PubDateAscComparator;
import coding_exercise_13.PubDateDescComparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static coding_exercise_14.Book.TITLE_COMPARATOR;

public class SetDemo {

    public static void main(String[] args) {

        System.out.println("Sorts books by publication year in title order:");
        treeSetDemo(TITLE_COMPARATOR);
        System.out.println();
        System.out.println("Sorts books by publication year in ascending order:");
        treeSetDemo(new Book.PubDateComparators.PubDateAscComparator());
        System.out.println();
        System.out.println("Sorts books by publication year in descending order:");
        treeSetDemo(new Book.PubDateComparators.PubDateDescComparator());
    }

    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books = null;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book book : books) {
            System.out.println(book);
        }

        return books;
    }
}