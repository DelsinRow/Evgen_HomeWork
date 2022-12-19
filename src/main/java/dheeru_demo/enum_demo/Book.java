package dheeru_demo.enum_demo;

public class Book {

    public enum BookGenre {

        BIOGRAPHY(12),
        HORROR(15);

        private int minAgeToRead;

        public static void main(String[] args) {
            for (BookGenre bookGenre : BookGenre.values()) {
                System.out.print("\nName: " + bookGenre); //toString
                System.out.print(", \nname(): " + bookGenre.name());
                System.out.print(", \nOrdinal: " + bookGenre.ordinal());
                System.out.print(", \nDeclaring Class: " + bookGenre.getDeclaringClass());
                System.out.print(", \ncompareTo(HORROR): " + bookGenre.compareTo(BookGenre.HORROR));
               System.out.print(", \nequals(HORROR): " + bookGenre.equals(BookGenre.HORROR));
                System.out.println();
            }
        }

     private BookGenre(int minAgeToRead) {
            this.minAgeToRead = minAgeToRead;
        }

      public int getMinAgeToRead() {
            return minAgeToRead;
        }
    }

}
