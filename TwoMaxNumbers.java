package com.BROADCOM.challengTwo;
/*********/
public class TwoMaxNumbers {
	 
    public void printTwoMaxNumbers(int[] nums){
        int maxOne = 0;
        int maxTwo = 0;
        for(int n:nums){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
        }
        System.out.println("First Max Number: "+maxOne);
        System.out.println("Second Max Number: "+maxTwo);
    }
     
    public static void main(String a[]){
       int num1[] = {5,34,78,2,45,1,99,23};
    	
    	int num2[]= { -1, 7, 3, -5, 4, -3, 1, 2 };
    	
        TwoMaxNumbers tmn = new TwoMaxNumbers();
        
        tmn.printTwoMaxNumbers(num1);
        
        tmn.printTwoMaxNumbers(num2);
        
        
        
    }
} 
