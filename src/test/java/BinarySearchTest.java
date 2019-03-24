import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    private final int[] oneNumberSequence = {6};
    private final int[] threeNumberSequence = {6, 7, 8};

    @Test
    public void testKeyIsFoundInOneNumberSequence() {
        int testKey = 6;

        Assert.assertEquals(1, oneNumberSequence.length);
        SearchResult searchResult = BinarySearch.search(testKey, oneNumberSequence);

        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(testKey, oneNumberSequence[searchResult.getPosition()]);
    }

    @Test
    public void testKeyIsNotFoundInOneNumberSequence() {
        int testKey = 4;
        int KEY_NOT_FOUND_IN_SEQUENCE_INDICATOR = -1;

        Assert.assertEquals(1, oneNumberSequence.length);
        SearchResult searchResult = BinarySearch.search(testKey, oneNumberSequence);

        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(KEY_NOT_FOUND_IN_SEQUENCE_INDICATOR, searchResult.getPosition());
    }

    @Test
    public void testKeyIsFirstElementInSequenceWithLengthMoreThanOne() {
        int testKey = 6;
        int firstPosition = 0;

        Assert.assertTrue(threeNumberSequence.length > 1);
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(testKey, threeNumberSequence[searchResult.getPosition()]);
        Assert.assertEquals(firstPosition, searchResult.getPosition());
    }

    @Test
    public void testKeyIsLastElementInSequenceWithLengthMoreThanOne() {
        int testKey = 8;
        int lastPosition = threeNumberSequence.length - 1;

        Assert.assertTrue(threeNumberSequence.length > 1);
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(testKey, threeNumberSequence[searchResult.getPosition()]);
        Assert.assertEquals(lastPosition, searchResult.getPosition());
    }

}
