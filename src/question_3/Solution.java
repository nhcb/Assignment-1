package question_3;

import java.util.Scanner;

/** Question 3 - Binary Tree
 * 
 * @author Nicky
 *
 */
public class Solution {

	public static void main(String[] args) {
		// Create scanner and ask input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter height of binary tree: ");
		int height = sc.nextInt();
		// Close scanner
		sc.close();
		// Create tree
		Tree tr = new Tree(height);
		// Print nodes of tree
		System.out.println("Printing nodes...");
		tr.printNodes();
		
	}

}
