package com.BROADCOM.challengTwo;
/***/
import java.util.*;

public class UserInput {
    public static void main(String[] args) {
    	System.out.println("Suggested number inputs are 2+2+2+2");
        List<String> list = new ArrayList<String>();
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("Current list is " + list);
            System.out.println("Add more? (y/n)");
            if (stdin.next().startsWith("y")) {
                System.out.println("Enter : ");
                list.add(stdin.next());
            } else {
                break;
            }
        } while (true);
        stdin.close();
        System.out.println("List is " + list);
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array is " + Arrays.toString(arr));
        
        
    }
}
