package algocrate.dynamic;
import algocrate.utils.Stopwatch;

/*
 * Returns the nth fibonacci number, provided integer n, using recursive approach. 
 * Time Complexity of 2^n, exponential 
 */
public class FibonacciRecursive {
	
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.print("Fibonacci number at position " + n + " is : " + fibonacci(n));
		
		Stopwatch stopwatch = new Stopwatch();
		
		// calculating time for 40 runs
		System.out.println("First hundred digits of fibonacci sequence are : ");
		for(int i = 1; i < 50; i++) {
			System.out.print(fibonacci(i) + " ");
			if (i % 10 == 0) System.out.println();
		}
		
		System.out.println("Time elapsed : " + stopwatch.elapsedTime() + " Seconds");
	}
}