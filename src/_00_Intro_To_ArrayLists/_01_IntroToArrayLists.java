package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    		ArrayList <String> list = new ArrayList<String>();
        // 2. Add five Strings to your list
    		list.add("a");
    		list.add("b");
    		list.add("c");
    		list.add("d");
    		list.add("e");
        // 3. Print all the Strings using a standard for-loop
    		for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
        // 4. Print all the Strings using a for-each loop
    		for(String s: list) {
    			System.out.println(s);
    		}
        // 5. Print only the even numbered elements in the list.
    		for (int i = 0; i < list.size(); i++) {
				if(i%2==0) {
					System.out.println(list.get(i));
				}
			}
        // 6. Print all the Strings in reverse order.
    		for (int i = list.size()-1; i >= 0; i--) {
				System.out.println(list.get(i));
			}
        // 7. Print only the Strings that have the letter 'e' in them.
    		for(int i=0; i<list.size(); i++) {
    			if(list.get(i).contains("e")) {
    				System.out.println(list.get(i));
    			}
    		}
    }

	private static char[] list(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
