package Coding_Exercise_5;

public class APIResponseParser {

    private final static String EMPTY_STRING = "";
    private final static String CHAR_TO_REMOVE = ",";

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +

                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +

                "</best_book>" +
                "</work>";

        APIResponseParser.bookParsing(response);


    }

    public static Book bookParsing(String response) {
        Book book = new Book();
        String[] startRuleArray = {"<title>", "<name>", "<original_publication_year type=\"integer\">",
                "<average_rating>", "<ratings_count type=\"integer\">", "<image_url>"};
        String endRule = "</";

        for (String startRule : startRuleArray) {

            String result = parse(response, startRule, endRule);

            if (!result.equals("")) {
                switch (startRule) {
                    case "<title>":
                        book.setTitle(result);
                        break;
                    case "<name>":
                        book.setAuthorName(result);
                        break;
                    case "<original_publication_year type=\"integer\">":
                        book.setPublicationYear(Integer.parseInt(result));
                        break;
                    case "<average_rating>":
                        book.setAverageRating(Double.parseDouble(result));
                        break;
                    case "<ratings_count type=\"integer\">":
                        book.setRatingsCount(Integer.parseInt(result.replace(CHAR_TO_REMOVE, EMPTY_STRING)));
                        break;
                    case "<image_url>":
                        book.setImageUrl(result);
                        break;
                }

            }

        }
        System.out.println("title: " + book.getTitle());
        System.out.println("name: " + book.getAuthorName());
        System.out.println("publicationYear: " + book.getPublicationYear());
        System.out.println("average rating: " + book.getAverageRating());
        System.out.println("ratings count: " + book.getRatingsCount());
        System.out.println("getImageUrl: " + book.getImageUrl());

        return book;
    }

        public static String parse(String response, String startRule, String endRule) {

            if (response.contains(startRule)) {

                int startIndex = response.indexOf(startRule) + startRule.length();
                int endIndex = response.indexOf(endRule, startIndex);
                return response.substring(startIndex,endIndex);

            } else {
                return EMPTY_STRING;
            }
        }





}