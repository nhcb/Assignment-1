package question_2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/** Question 2
 * 
 * @author Nicky
 *
 */
public class Solution {
	

	public static void main(String args[]) {
		// Open scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("String to subset: ");
		// Input
		String str = sc.nextLine();
		// Close scanner
		sc.close();
		// Recursively generate subset
		generateSubset(str);
	}
	
	/** Recursive method to generate a subset of given string
	 * 
	 * @param set the string that needs to be subsetted.
	 */
	public static void generateSubset(String set) {
		// Create a set called subset, which stores all subsets of given string (set).
		Set<String> subset = new TreeSet<String>();
		// Add the empty collection to the set
		subset.add("");
		// Generate subset of each substring in given string
		if(set.length()>0) {
			for(int i = 0; i < set.length(); i ++) {
				generateSubset(set.substring(i,set.length()),"", subset);
			}
		}
		// Print the result
		System.out.println(subset);
	}

	/** Recursive method to generate a subset of a given string
	 * 
	 * @param set the string that needs to be subsetted
	 * @param text the substring that is to be added to the subset
	 * @param subset the set of all current elements in the subset
	 */
	public static void generateSubset(String set,String text,Set<String> subset) {
		if(!text.equals("")) {
			subset.add(text);
		}

		if(set.length()>0) {
			for(int i = 0; i < set.length(); i ++) {
				generateSubset(set.substring(i+1,set.length()), text + Character.toString(set.charAt(i)), subset);
			}
		}
	}
}
