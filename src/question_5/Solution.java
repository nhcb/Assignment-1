package question_5;

import java.util.Scanner;

/** Question 5, English ruler
 * 	An English ruler is a ruler in which each major unit has major tick marks,
 *	and minor units have minor tick marks occurring at successive halves. 
 * 
 * @author Nicky
 *
 */
public class Solution {
	
	/** Method that draws an english ruler recursively
	 * 
	 * @param nInches the amount of inches on the ruler
	 * @param majorLength the length of the major tick mark and thus determines how many successive halves are drawn
	 */
	public static void drawRuler(int nInches, int majorLength) {
		// Draw the first major unit 0 with major tick mark majorLength
		drawLine(majorLength, 0);
		for (int j = 1; j <= nInches; j++) {
			// Recursively draw successive halves between the major units
			drawSuccessiveHalf(majorLength - 1);
			// Draw the j'th major unit
			drawLine(majorLength, j);
		}
	}
	/** Method to recursively draw the ticks between major units on the successive halves
	 * 
	 * @param previousTickLength the length of previous tick 
	 */
	private static void drawSuccessiveHalf(int previousTickLength) {
		
		if (previousTickLength >= 1) {
			// Recursive call
			drawSuccessiveHalf(previousTickLength - 1);
			// Draw a line of tickLength equal to previousTickLength, however tickLabel -1 to prevent printing label
			drawLine(previousTickLength,-1);
			// Recursive call
			drawSuccessiveHalf(previousTickLength - 1);
		}
	}

	/** Method that prints the ticks + label (if available)
	 * 
	 * @param tickLength how many ticks to be printed
	 * @param tickLabel what label to be printed ( if -1, no label is printed)
	 */
	private static void drawLine(int tickLength, int tickLabel) {
		// Print ticks equal to the amount of tickLength
		for (int j = 0; j < tickLength; j++) {
						System.out.print("-");
		}
		// When the tickLabel is equal or greater than 0, print the label
		if (tickLabel >= 0) {
			System.out.print(" " + tickLabel);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// Open scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount of inches: ");
		int inch = sc.nextInt();
		System.out.print("Enter major tick length: ");
		int tick = sc.nextInt();
		// Close scanner
		sc.close();
		// Draw ruler
		drawRuler(inch,tick);
		
	}
}