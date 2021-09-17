package com.BROADCOM.challengTwo;

//Reference https://algorithmssinjava.blogspot.com/2017/09/java-method-that-takes-integer-n-and.html
/*
 * Java methods that takes an integer n and returns 
 * both the sum and product of all positive integers less than or equal to n. 
 */
import java.util.Scanner;

public class FindSum {

	static int number = 0;
	static int product = 0;

	public static void main(String[] args) {
		FindSum findSum = new FindSum();
		number = findSum.getTheNumber();
		System.out.println("The sum of all positive integers less than or equal to N is:  " + findSum.findSum(number));
		product = findproduct(number);
		System.out.println("The prod of all positive integers less than or equal to N is:  " + findproduct(number));

	}

	/**
	 * Method gets input from user
	 * @return
	 */
	public int getTheNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number!");
		number = scanner.nextInt();

		scanner.close();

		return number;
	}

	/**
	 * Finds the Sum
	 * @param number
	 * @return
	 */
	public int findSum(int number) {
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum = sum + i;
		}
		return sum;
	}
/**
 * Finds the Product
 * @param number
 * @return
 */
	public static int findproduct(int number) {
		int product = 0;
		for (int i = 1; i <= number; i++) {
			product=number*number;			
		
	}
		return product;

}
	
}
