import java.util.HashMap;
import static java.lang.Math.min;

public class AnagramChecker {

    public static int countOfDifference(String strOne, String strTwo) {
        if(strOne.length()!=strTwo.length()) {
            return -1;
        } else if(isAnagram(strOne, strTwo)) {
            return 0;
        } else {
            int overallSame = 0;

            //compare hashmaps
            HashMap<Character, Integer> strOneMap = convertToCharIntMap(strOne);
            HashMap<Character, Integer> strTwoMap = convertToCharIntMap(strTwo);

            //compare key for key
            for (char c: strOneMap.keySet()) {
                //count which are the same
                if(strTwoMap.containsKey(c)) {
                    int strOneCount = strOneMap.get(c);
                    int strTwoCount = strTwoMap.get(c);
                    overallSame += min(strOneCount, strTwoCount);
                }
            }

            //length of strings are the same, so take whichever string and subtract the count of same
            return strOne.length() - overallSame;
        }
    }

    //Returns true if the strings are anagrams
    public static boolean isAnagram(String strOne, String strTwo) {
        HashMap<Character, Integer> strOneMap = convertToCharIntMap(strOne);
        HashMap<Character, Integer> strTwoMap = convertToCharIntMap(strTwo);

        return strOneMap.equals(strTwoMap);
    }

    //Helper method
    private static HashMap<Character, Integer> convertToCharIntMap(String str) {
        HashMap<Character, Integer> strMap = new HashMap<>();
        char[] strOneCharArray = str.toLowerCase().toCharArray();

        for (char c: strOneCharArray) {
            if(strMap.containsKey(c)) {
                int count = strMap.get(c);
                count++;
                strMap.put(c, count);
            } else {
                strMap.put(c, 1);
            }
        }

        return strMap;
    }
}
