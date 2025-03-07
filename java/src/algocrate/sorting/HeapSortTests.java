package algocrate.sorting;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algocrate.utils.Stopwatch;

import java.util.Arrays;
import java.util.Random;

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
        Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < size; i++) {
            input[i] = size - i;  // Descending order
            expected[i] = i + 1;  // Sorted order
        }

        Heap.sort(input);
        Assert.assertEquals(input, expected, "HeapSort failed on large input");
        System.out.println("Heapsort took : " + stopwatch.elapsedTime() + " secs" + " to sort " + size + " elements");
        System.out.println("\n" + "-------------------------------------------------");
        
    }
    
    private static final int INITIAL_N = 1000; // Starting size
    private static final int MAX_DOUBLINGS = 12; // Number of times to double N
    private static final Random random = new Random();

    @Test
    public void testMergeSortDoubling() {
        int N = INITIAL_N;

        double prevTime = 0.0; // Store previous run time to compare growth rate
        
        System.out.println("DOUBLING TEST" + " " + MAX_DOUBLINGS + " TIMES");
        for (int i = 0; i < MAX_DOUBLINGS; i++) {
            Integer[] array = generateRandomArray(N);
            Integer[] copy = Arrays.copyOf(array, array.length); // Copy for validation

            Stopwatch stopwatch = new Stopwatch();
            Heap.sort(array);
            double elapsedTime = stopwatch.elapsedTime();

            // Validate sorting correctness
            Arrays.sort(copy);
            Assert.assertEquals(array, copy, "Heap Sort failed for N=" + N);

            // Print results
            System.out.printf("N = %d, Time = %.6f seconds", N, elapsedTime);
            if (i > 0) {
                System.out.printf(", Time Ratio = %.2f", elapsedTime / prevTime);
            }
            System.out.println();

            prevTime = elapsedTime;
            N *= 2; // Double N for next iteration
        }
        System.out.println("\n" + "-------------------------------------------------");
    }

    private Integer[] generateRandomArray(int N) {
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(1000000); // Random values
        }
        return array;
    }
}
