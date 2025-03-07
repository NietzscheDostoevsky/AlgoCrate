// Testcases to check the implementation validity of differnt sorting algos. 

package algocrate.sorting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;

public class SortingTests {

    @DataProvider(name = "sortingData")
    public Object[][] sortingData() {
        return new Object[][] {
            {new Integer[]{5, 2, 9, 1, 5, 6}},
            {new Integer[]{3, -1, 4, 1, 5, 9, 2, 6, 5}},
            {new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}},
            {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
            {new Integer[]{42}}, // Single element
            {new Integer[]{}}, // Empty array
        };
    }

//    @Test(dataProvider = "sortingData")
//    public void testMergeSort(Integer[] input) {
//        Integer[] expected = input.clone();
//        Arrays.sort(expected);
//        MergeSort.sort(input);
//        Assert.assertEquals(input, expected, "MergeSort failed");
//    }
//
//    @Test(dataProvider = "sortingData")
//    public void testSelectionSort(Integer[] input) {
//        Integer[] expected = input.clone();
//        Arrays.sort(expected);
//        SelectionSort.sort(input);
//        Assert.assertEquals(input, expected, "SelectionSort failed");
//    }
//
//    @Test(dataProvider = "sortingData")
//    public void testQuickSort(Integer[] input) {
//        Integer[] expected = input.clone();
//        Arrays.sort(expected);
//        QuickSort.sort(input);
//        Assert.assertEquals(input, expected, "QuickSort failed");
//    }

    @Test(dataProvider = "sortingData")
    public void testHeapSort(Integer[] input) {
        Integer[] expected = input.clone();
        Arrays.sort(expected);
        Heap.sort(input);
        Assert.assertEquals(input, expected, "HeapSort failed");
    }
}
