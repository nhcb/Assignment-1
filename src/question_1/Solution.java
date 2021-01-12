package question_1;

import java.util.Scanner;

/** Question 1
 * 
 * @author Nicky
 *
 */
public class Solution {

	public static void main(String[] args) {
		// Open scanner and ask input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter word: ");
		String haystack = sc.next();
		System.out.print("Enter substring to be found in " + haystack + ": ");
		String needle = sc.next();
		// Close scanner
		sc.close();
		// Run method
		System.out.println("The index on " + needle + " in " + haystack + " equals " + indexOf(haystack,needle));
	}
	
	/** Method that returns the starting position of the first substring, needle, in haystack
	 * 
	 * @param haystack a string
	 * @param needle a substring of string
	 * @return the starting position of needle when in haystack, else -1
	 */
	public static int indexOf(String haystack, String needle) {
	
		// Length of needle
		int lengthNeedle = needle.length();
		// Detect if the needle is in the haystack 
		// specifically the substring of current iteration and current iteration plus lengthNeedle
		if(needle.equals(haystack.substring(0,lengthNeedle))) {
			return 0;
		}
		else {
			return indexOf(haystack,needle,1);
		}
		
	}
	
	/** Method that returns the starting position of the first substring, needle, in haystack
	 * 
	 * @param haystack a string 
	 * @param needle a substring of haystack
	 * @param index the current index that is to be evaluated in haystack
	 * @return
	 */
	public static int indexOf(String haystack, String needle,int index) {
		// Length of needle
		int lengthNeedle = needle.length();
		int lengthHaystack = haystack.length();
		// Detect if the needle is in the haystack 
		// specifically the substring of current iteration and current iteration plus lengthNeedle

		if(index + lengthNeedle < lengthHaystack) {
			if(needle.equals(haystack.substring(index,index+lengthNeedle))) {
				return index;
			}
			else {
				return indexOf(haystack,needle,index+1);
			}
		}
		else {
			return -1;
		}
	}
}
