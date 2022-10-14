import java.util.Scanner;
public class Assignment4 {

    public static void main(String[] args) {
        System.out.print("Hi, please enter something. Some word, ofc: ");
        Scanner sc = new Scanner (System.in);
        String term = sc.nextLine();
        String doc = "No one just throws a high kick; only people who dedicate their life to martial arts or ballet are able to get their leg that high that easily. " +
                      "Be it Jean Claude Van Damme or Saenchai, everyone who throws a high kick has spent years mastering it. You need great static and dynamic flexibility, great technique and, most important of all, the ability to set up your opponent for that highlight reel KO.";

        System.out.println("Term frequency = " + termFrequency(term , doc));
    }

        //returns the number of times term appears in the document
        public static int getFrequencyCount(String term, String doc) {
            term = term.toLowerCase();
            doc = doc.toLowerCase();
            int frequencyCount = 0;
            int index = doc.indexOf(term);
            while (index >= 0) {
                frequencyCount++;
                doc = doc.substring(index + term.length());
                index = doc.indexOf(term);
            }
            return frequencyCount;
        }

        //will take a term and document and returns the term frequency weight
        public static double termFrequency(String term, String doc) {
            int frequencyCount = getFrequencyCount(term, doc);
            int totalTermCount = doc.split(" ").length;
            System.out.println("Finding term frequency for '" + term +"' :");
            System.out.println(frequencyCount);
            System.out.println(totalTermCount);

            return (double) frequencyCount/totalTermCount;
        }




}
