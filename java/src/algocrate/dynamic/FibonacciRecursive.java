package algocrate.dynamic;

/*
 * Returns the nth fibonacci number, provided integer n, using recursive approach. 
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
	}
}