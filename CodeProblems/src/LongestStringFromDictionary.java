import java.util.*;

public class LongestStringFromDictionary {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("ale", "apple", "monkey", "plea");

        System.out.println(findLongestString(dict, "abpcplea"));
        System.out.println(findLongestString(dict, "mtoantkedy"));
    }

    public static String findLongestString(List<String> dict, String str) {
        String longest = "";

        for (String word : dict) {
            if (word.length() > longest.length()) {
            if (isSubsequence(word, str)) {
                    longest = word;
                }
            }
        }

        return longest;
    }

    public static boolean isSubsequence(String word, String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (i < word.length() && word.charAt(i) == c) {
                i++;
            }
        }
        return i == word.length();
    }
}
