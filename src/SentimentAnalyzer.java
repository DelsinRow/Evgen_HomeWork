/**
 * No implement checkForOpinionFirstPattern method
 */

import java.util.Arrays;

public class SentimentAnalyzer {

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        String review2 = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

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

        for(int k = 0; k < featureOpinions.length; k++) {
            for (int i = 0; i < featureSet.length; i++) {
                for (int j = 0; j < featureSet[i].length; j++) {
                    feature = featureSet[i][j];
                    featureOpinions[k] = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                }
            }
        }
        return featureOpinions;
    }


    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int result = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (result == 0){
            result = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
       return result;
    }

    private static boolean isStrInReview(String review, String str){
        int index = review.indexOf(str);
        String newStr = review.substring(index);
        boolean strBoolean = review.startsWith(newStr, index);
        if(strBoolean){
            return true;
        } else {
            return false;
        }
    }
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        if(isStrInReview(review, pattern)) {
            for(String strPos : posOpinionWords){
                if (isStrInReview(review, (pattern + strPos))) {
                    opinion++;
                }
            }
            for (String strNeg : negOpinionWords) {
                if (isStrInReview(review, (pattern + strNeg))) {
                    opinion--;
                }
            }
        }
        return opinion;
    }


    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;

        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)

        return opinion;
    }


}