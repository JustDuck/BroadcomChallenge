package com.BROADCOM.challengTwo;

//Java implementation to Print N distinct
//numbers such that their sum is 0
public class tryThis {

	static int sum = 0;
	static int product = 0;

	/**
	 * Method findNumbers
	 * 
	 * @param N
	 */

	static void findNumbers(int N) {

		for (int i = 1; i <= N / 2; i++) {
			// Print 2 symmetric numbers
			System.out.print(i + ", " + -i + ", ");
			// sum = 0;
			// product = 0;
			sum = sum + i; // LINE A
			product = sum * sum; // LINE B
			System.out.println("Sum after adding " + i + " is : " + sum);
			System.out.println("Product after multiplying " + i + " is : " + product);
		}

		System.out.println("The sum and product are " + sum + " and " + product);

		// Print a extra 0 if N is odd
		// so try N = 9
		if (N % 2 == 1) {

			System.out.println(" Its ODD " + N);
			System.out.print(0);
		}
		if (N == 0 || N == 1)

		{
			System.out.println(N + " is not prime number");
			System.out.println(" Its negative " + N);
			System.out.print(0);
		}

	}

	// Driver code
	public static void main(String[] args) {
		int N = 8;// he said given n = 8 not 10 try 9, but 8 is good
		findNumbers(N);
		System.out.println("N  of array elements is: " + N);
		System.out.println("1, -1, 2, -2, 3, -3, 4, -4, 5, -5");
		System.out.println("As you can see from above, that yes those integers would add up to be Zero");
		System.out.println("But added as 1+2+3+4+5 you get 15");
	}
}

// 1, -1, 2, -2, 3, -3, 4, -4, 5, -5,
