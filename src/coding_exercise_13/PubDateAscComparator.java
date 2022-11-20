package coding_exercise_13;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getYear() > o2.getYear()) {
            return 1;
        } else if (o1.getYear() < o2.getYear()){
            return -1;
        }  else if (o1.getYear()  == o2.getYear()) {
            return o1.getTitle().compareTo(o2.getTitle());
        } else {
            return 0;
        }
    }
}

