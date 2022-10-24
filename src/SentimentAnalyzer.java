/**
 * No implement checkForOpinionFirstPattern method
 */

import java.util.Arrays;

public class SentimentAnalyzer {

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        review = review.toLowerCase();
        //String review2 = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {

        int[] featureOpinions = new int[featureSet.length];
        String feature;     //объявить здесь или в цикле?

  //      for(int k = 0; k < featureOpinions.length; k++) {
            for (int i = 0; i < featureSet.length; i++) {
                for (int j = 0; j < featureSet[i].length; j++) {
                    feature = featureSet[i][j];
                    featureOpinions[i] = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                    if(featureOpinions[i] != 0) {
                        break;
                    }

                }
            }
   //     }
        return featureOpinions;
    }


    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int result = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (result == 0){
            result = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
       return result;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        if(review.contains(pattern)) {
            for(String strPos : posOpinionWords){
                if (review.contains(pattern + strPos)) {
                    opinion++;

                }
            }
            for (String strNeg : negOpinionWords) {
                if (review.contains(pattern + strNeg)) {
                    opinion--;

                }
            }

        }

        return opinion;
    }


    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        //String[] sentences = review.split("\\.");
        int opinion = 0;
        String pattern = " " + feature;

        if(review.contains(pattern)) {
            for(String strPos : posOpinionWords){
                if (review.contains(strPos + pattern)) {
                    opinion++;
                    break;
                }
            }
            for (String strNeg : negOpinionWords) {
                if (review.contains(strNeg + pattern)) {
                    opinion--;
                    break;
                }
            }
        }
        return opinion;

    }


}