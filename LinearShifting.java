package com.BROADCOM.challengTwo;

import java.util.Arrays;

// Reference = see https://stackoverflow.com/questions/4897280/given-an-array-of-positive-and-negative-integers-re-arrange-it-so-that-you-have

public class LinearShifting {

	public static void main(String[] args) {

		int[] a = { -1, 7, 3, -5, 4, -3, 1, 2 };

		System.out.println("The number of elements is " + a.length);
		sort(a);
		System.out.println("The original array before sorting " + Arrays.toString(a));
		// output: [-1, -5, -3, 7, 3, 4, 1, 2]
		// now multiply to get a product / sum

		int sum = 0;

		// Advanced for loop
		for (int num : a) {

			if (num == 0) {
				System.out.println("Number is equal to zero");
			} else if (num > 0) {
				System.out.println("Number is positive");
			} else {
				System.out.println("Number is negative");
			}

			sum = sum + num * num; // Sum of array elements is:90
			Arrays.sort(a);
			// System.out.println("Sorted " + Arrays.toString(a));

		}
		System.out.println("Sum of array elements is: " + sum);

		// checks for negatives in the array
		int rtn = 1;
		for (int i : a) {

			rtn *= i;
		}

		System.out.println("Product  is: " + rtn);
		if (rtn < 0) {
			System.out.println("Product is negative: " + rtn);
		}

		if (rtn == 0) {
			System.out.println("Product is zero : " + rtn);

		}
		if (rtn > 0) {
			System.out.println("Product is positive: " + rtn);
		} else {
			// System.out.println("Good evening.");
		}
		Arrays.sort(a);
		System.out.println("Sorted " + Arrays.toString(a));
	}

	/**
	 * This version of the method is not used
	 * 
	 * @param a
	 */
	public static void sort(int[] a) {
		int pos = 0;
		int neg = 0;
		int i, j;
		int max = Integer.MIN_VALUE;
		for (i = 0; i < a.length; i++) {
			if (a[i] < 0)
				neg++;
			else
				pos++;
			if (a[i] > max)
				max = a[i];
		}
		max++;
		if (neg == 0 || pos == 0)
			return;// already sorted

		i = 0;
		j = 1;
		while (true) {
			while (i <= neg && a[i] < 0)
				i++;
			while (j < a.length && a[j] >= 0)
				j++;
			if (i > neg || j >= a.length)
				break;
			a[i] += max * (i + 1);
			swap(a, i, j);
		}

		i = a.length - 1;
		while (i >= neg) {
			int div = a[i] / max;
			if (div == 0)
				i--;
			else {
				a[i] %= max;
				swap(a, i, neg + div - 2);// minus 2 since a[i]+= max*(i+1);
			}
		}

	}

	/**
	 * Method not used
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * Method not used
	 * 
	 * @param a
	 * @return
	 */
	public static int arrayProduct(int[] a) {
		int rtn = 1;
		for (int i : a) {
			rtn *= i;
		}
		return rtn;
	}
}
