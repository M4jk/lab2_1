import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class BinarySearchTest {

    private final int[] zeroNumberSequence = {};
    private final int[] oneNumberSequence = {6};
    private final int[] threeNumberSequence = {6, 7, 8};
    private final int KEY_NOT_FOUND_IN_SEQUENCE_INDICATOR = -1;

    @Test
    public void testKeyIsFoundInOneNumberSequence() {
        int testKey = 6;

        Assert.assertThat(oneNumberSequence.length, is(1));
        SearchResult searchResult = BinarySearch.search(testKey, oneNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(oneNumberSequence[searchResult.getPosition()], is(testKey));
    }

    @Test
    public void testKeyIsNotFoundInOneNumberSequence() {
        int testKey = 4;

        Assert.assertThat(oneNumberSequence.length, is(1));
        SearchResult searchResult = BinarySearch.search(testKey, oneNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(false));
        Assert.assertThat(searchResult.getPosition(), is(KEY_NOT_FOUND_IN_SEQUENCE_INDICATOR));
    }

    @Test
    public void testKeyIsFirstElementInSequenceWithLengthMoreThanOne() {
        int testKey = 6;
        int firstPosition = 0;

        Assert.assertThat(threeNumberSequence.length, greaterThan(1));
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(threeNumberSequence[searchResult.getPosition()], is(testKey));
        Assert.assertThat(searchResult.getPosition(), is(firstPosition));
    }

    @Test
    public void testKeyIsLastElementInSequenceWithLengthMoreThanOne() {
        int testKey = 8;
        int lastPosition = threeNumberSequence.length - 1;

        Assert.assertThat(threeNumberSequence.length, greaterThan(1));
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(threeNumberSequence[searchResult.getPosition()], is(testKey));
        Assert.assertThat(searchResult.getPosition(), is(lastPosition));
    }

    @Test
    public void testKeyIsMiddleElementInSequenceWithLengthMoreThanOne() {
        int testKey = 7;
        int middlePosition = (threeNumberSequence.length - 1) / 2;

        Assert.assertThat(threeNumberSequence.length, greaterThan(1));
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(threeNumberSequence[searchResult.getPosition()], is(testKey));
        Assert.assertThat(searchResult.getPosition(), is(middlePosition));
    }

    @Test
    public void testKeyIsNotFoundInSequenceWithLengthMoreThanOne() {
        int testKey = 4;

        Assert.assertThat(threeNumberSequence.length, greaterThan(1));
        SearchResult searchResult = BinarySearch.search(testKey, threeNumberSequence);

        Assert.assertThat(searchResult.isFound(), is(false));
        Assert.assertThat(searchResult.getPosition(), is(KEY_NOT_FOUND_IN_SEQUENCE_INDICATOR));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSequenceWithoutElements() {
        int testKey = 6;

        BinarySearch.search(testKey, zeroNumberSequence);
    }
}
