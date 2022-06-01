import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramCheckerTest {

    @Test
    public void isAnagramTest() {
        String strOne = "ate";
        String strTwo = "tea";

        assertTrue(AnagramChecker.isAnagram(strOne, strTwo));
    }

    @Test
    public void countOfDifference_CaseInsensitive_DiffLettersTest() {
        String strOne = "abb";
        String strTwo = "BBC";

        assertEquals(1, AnagramChecker.countOfDifference(strOne, strTwo));
    }

    @Test
    public void countOfDifference_DiffLengthTest() {
        String strOne = "a";
        String strTwo = "ab";

        assertEquals(-1, AnagramChecker.countOfDifference(strOne, strTwo));
    }

    @Test
    public void countOfDifference_DiffLettersTest() {
        String strOne = "bbb";
        String strTwo = "aaa";

        assertEquals(3, AnagramChecker.countOfDifference(strOne, strTwo));
    }

    @Test
    public void countOfDifference_AnagramTest() {
        String strOne = "tea";
        String strTwo = "ate";

        assertEquals(0, AnagramChecker.countOfDifference(strOne, strTwo));
    }

    @Test
    public void countOfDifference_OneOverlappingCharTest() {
        String strOne = "abbc";
        String strTwo = "bbcc";

        assertEquals(1, AnagramChecker.countOfDifference(strOne, strTwo));
    }

    @Test
    public void countOfDifference_DifferentOrderTest() {
        String strOne = "abbc";
        String strTwo = "bbcc";

        assertEquals(1, AnagramChecker.countOfDifference(strTwo, strOne));
    }

    @Test
    public void countOfDifference_MoreThanOneCharDiffTest() {
        String strThree = "abba";
        String strFour = "bbcc";

        assertEquals(2, AnagramChecker.countOfDifference(strThree, strFour));
    }

}