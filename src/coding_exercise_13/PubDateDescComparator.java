package coding_exercise_13;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o2.getYear() > o1.getYear()) {
            return 1;
        } else if (o2.getYear() < o1.getYear()){
            return -1;
        }  else {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    }
}
