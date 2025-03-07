package algocrate.sorting;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;

public class HeapSortTests {

    @DataProvider(name = "arraysToSort")
    public Object[][] provideArrays() {
        return new Object[][]{
            {new Integer[]{5, 3, 8, 4, 2, 7, 1, 6}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}}, // Random order
            {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}}, // Already sorted
            {new Integer[]{8, 7, 6, 5, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}}, // Reverse sorted
            {new Integer[]{3, 3, 3, 3, 3, 3}, new Integer[]{3, 3, 3, 3, 3, 3}}, // All elements same
            {new Integer[]{42}, new Integer[]{42}}, // Single element
            {new Integer[]{}, new Integer[]{}}, // Empty array
        };
    }

    @Test(dataProvider = "arraysToSort")
    public void testHeapSort(Integer[] input, Integer[] expected) {
        Heap.sort(input);  // Sort in-place
        Assert.assertEquals(input, expected, "HeapSort failed for input: " + Arrays.toString(input));
    }

    @Test
    public void testHeapSortWithDuplicates() {
        Integer[] input = {4, 5, 5, 2, 1, 1, 3};
        Integer[] expected = {1, 1, 2, 3, 4, 5, 5};
        Heap.sort(input);
        Assert.assertEquals(input, expected, "HeapSort failed with duplicate elements");
    }

    @Test
    public void testHeapSortNegativeNumbers() {
        Integer[] input = {-5, -1, -3, -2, -4};
        Integer[] expected = {-5, -4, -3, -2, -1};
        Heap.sort(input);
        Assert.assertEquals(input, expected, "HeapSort failed with negative numbers");
    }

    @Test
    public void testHeapSortLargeArray() {
        int size = 10000;
        Integer[] input = new Integer[size];
        Integer[] expected = new Integer[size];

        for (int i = 0; i < size; i++) {
            input[i] = size - i;  // Descending order
            expected[i] = i + 1;  // Sorted order
        }

        Heap.sort(input);
        Assert.assertEquals(input, expected, "HeapSort failed on large input");
    }
}
