package com.BROADCOM.challengTwo;

//Reference https://stackoverflow.com/questions/20550037/find-maximum-product-of-3-numbers-in-an-array

import java.util.Arrays;

public class MaxProdofThreenumbers {
	public int ThreeLargeNumbers(int[] a) {
		int topfirstpos = 0;// positives
		int topsecpos = 0;// positives
		int topthirdpos = 0;// positives
		int topfirstneg = 0;// negatives
		int topsecneg = 0;// negatives
		int prodneg = 0;// negatives
		int prodpos = 0;// positives
		int prodmax = 0;// maximums
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			String num = a[i] + "";
			if (num.contains("-")) {
				String array[] = num.split("-");
				num = array[1];
				flag = true;
			} else
				flag = false;
			if (flag) {
				if (topfirstneg < Integer.valueOf(num)) {
					topsecneg = topfirstneg;
					topfirstneg = Integer.valueOf(num);
				} else if (topsecneg < Integer.valueOf(num)) {

					topsecneg = Integer.valueOf(num);
				}
			} else {
				if (topfirstpos < Integer.valueOf(num)) {
					topsecpos = topfirstpos;
					topfirstpos = Integer.valueOf(num);
				} else if (topsecpos < Integer.valueOf(num)) {
					topthirdpos = topsecpos;
					topsecpos = Integer.valueOf(num);
				} else if (topthirdpos < Integer.valueOf(num)) {
					topthirdpos = Integer.valueOf(num);
				}
			}
		}
		prodneg = topfirstneg * topsecneg;
		prodpos = topfirstpos * topsecpos;

		if (prodneg > prodpos) {
			prodmax = prodneg * topfirstpos;
		} else {
			prodmax = prodpos * topthirdpos;
		}
		return prodmax;
	}

	public static void main(String a[]) {
		int list1[] = { -29, 3, -2, -57, 8, -789, 34 };// 1529082

		int list2[] = { 4, 5, -19, 3 };// 60 = 4*5*3=60

		int list3[] = { 2, 5, -19, 3 };// 30 = 2*5*3=30

		int list4[] = { 1, 2, -3, 4 };// comes out to be one not now its 0???

		MaxProdofThreenumbers t = new MaxProdofThreenumbers();
		System.out.println(t.ThreeLargeNumbers(list1) + " the 3 larger numbers are");
		System.out.println(t.ThreeLargeNumbers(list1) + " the larger list is");

		System.out.println(t.ThreeLargeNumbers(list2) + " the 3 larger numbers are");
		System.out.println(t.ThreeLargeNumbers(list2) + " the larger list is");

		System.out.println(t.ThreeLargeNumbers(list3) + " the 3 larger numbers are");
		System.out.println(t.ThreeLargeNumbers(list3) + " the larger list is");

		System.out.println(t.ThreeLargeNumbers(list4) + " the 3 larger numbers are");
		System.out.println(t.ThreeLargeNumbers(list4) + " the larger list is");

		Arrays.sort(list1);
		Arrays.sort(list2);
		Arrays.sort(list3);
		Arrays.sort(list4);

		Arrays.toString(list1);
		Arrays.toString(list2);
		Arrays.toString(list3);
		Arrays.toString(list4);

		System.out.println((Arrays.toString(list1)) + " Sorted LIST 1");
		System.out.println((Arrays.toString(list2)) + " Sorted LIST 2");
		System.out.println((Arrays.toString(list3)) + " Sorted LIST 3");
		System.out.println((Arrays.toString(list4)) + " Sorted LIST 4");

	}
}
