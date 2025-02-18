package algocrate.dynamic;

import algocrate.utils.Stopwatch;

/*
 * Returns the nth fibonacci number, provided integer n, using Matrix Exponentiation approach. 
 * Time complexity : O(log(n)), Space : O(1), highly efficient algo. 
 */
public class FibonacciMatrix {

	// Returns the nth digit of the Fibonacci series
	public static int fibonacciMatrix(int n) {
		if (n <= 1) {
			return n;
		}

		int[][] F = { { 1, 1 }, { 1, 0 }, };

		int[][] result = matrixPower(F, n - 1);
		return result[0][0]; // The top left element gives F(n)
	}

	// Matrix Exponentiation
	private static int[][] matrixPower(int[][] M, int n) {
		int[][] result = { { 1, 0 }, { 0, 1 }, }; // Identity Matrix

		int[][] base = M;

		while (n > 0) {
			if (n % 2 == 1) {
				result = matrixMultiply(result, base);
			}
			base = matrixMultiply(base, base);
			n /= 2;
		}
		return result;
	}

	// Matrix Multiplication for a 2x2 array, hardcoded operations are faster than
	// loops
	private static int[][] matrixMultiply(int[][] A, int[][] B) {
		int[][] result = new int[2][2];

		result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
		result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
		result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
		result[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];

		return result;
	}

	// testing the code
	public static void main(String[] args) {
		int n = 10;
		System.out.print("Fibonacci number at position " + n + " is : " + fibonacciMatrix(n));

		Stopwatch stopwatch = new Stopwatch();

		// calculating time for 40 runs
		System.out.println("First hundred digits of fibonacci sequence are : ");
		for (int i = 1; i < 40; i++) {
			System.out.print(fibonacciMatrix(i) + " ");
			if (i % 10 == 0)
				System.out.println();
		}

		System.out.println("\nTime elapsed : " + stopwatch.elapsedTime() + " Seconds");
	}
}
