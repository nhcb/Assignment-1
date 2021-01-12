package question_6;

import java.util.ArrayList;
import java.util.Scanner;

/** Question 6, summation puzzle solver
 * 
 * @author Nicky
 *
 */
public class Solution {

	private static String puzzle;
	private static ArrayList<Character> letters = new ArrayList<Character>();
	private static int solutionCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the summation puzzle: ");
		// Get input
		puzzle = sc.nextLine();
		// Close scanner
		sc.close();
		// Solve puzzle
		Long startTime = System.nanoTime();
		solve(puzzle);
		Long endTime = System.nanoTime();
		System.out.println("Excecuted in " + (endTime - startTime)/1_000_000 + " miliseconds.");
	}
	/** General method for solving the puzzle, this builds everything and calls all other methods
	 * 
	 * @param puzzle the summation puzzle to solve
	 */
	public static void solve(String puzzle) {
		// Obtain unique characters
		letters = obtainUnique();
		
		// Define an array that will hold the sequence of numbers
		ArrayList<String> sequence = new ArrayList<String>();
		
		// Define an array that will hold numbers 0-9 that we can choose from
		ArrayList<String> numbers = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			numbers.add(Integer.toString(i));
		}
		
		// Recursively solve puzzle
		solvePuzzle(letters.size(),sequence,numbers);
		System.out.println("Solution(s) found: " + solutionCount);
	}
	
	/** Method to recursively solve the summation puzzle
	 * 
	 * @param k an integer that implies how many unique letters have not yet been assigned an integer
	 * @param seq a String ArrayList that holds the sequence of numbers used for the letters
	 * @param num a String ArrayList that holds the numbers used in seq
	 */
	public static void solvePuzzle(int k,ArrayList<String> seq, ArrayList<String> num) {
		
		for (int i = 0; i < num.size(); i++) { 
			// For every number in array num, add this to seq and remove from num
			String number = num.get(i);
			seq.add(number);                           
			num.remove(number);                       
			// If k==1, there are an equal amount of numbers 0-9 added to seq as there are elements in letters
			// One should check if the current configuration of seq gives a right solution
			if (k == 1) {
				checkSolution(seq);
			}
			// If k=!1 , there are not yet an equal amount of numbers 0-9 added to seq as there are elements in letters
			// Hence we call solvePuzzle again
			else {
				solvePuzzle(k - 1, seq, num);
			}
			seq.remove(number);                        
			num.add(i, number);                        
		}
	}
	/** Method to check if given sequence is a correct solution for the summation puzzle
	 * 
	 * @param seq given sequence that corresponds with letters
	 */
	public static void checkSolution(ArrayList<String> seq) {
		// Replace the letters in the given puzzle with integers given in seq
		int counter = 0;
		int summation = 0;
		int answer = 0;
		String result = puzzle;
		
		for (int i = 0; i < letters.size(); i++) {
			result = result.replaceAll(letters.get(i).toString(), seq.get(counter));
			counter++;
			// Reset counter if
			if (counter >= seq.size()) {
				counter = 0;
			}
		}
		
		// Trim whitespaces from result and split by + and =
		String[] resultArray = result.replaceAll("\\s","").split("[\\+=]");
		// Read answer, which is the last element (remove this element)
		answer = Integer.parseInt(resultArray[resultArray.length - 1]);
		
		// Summation puzzle, hence sum all but the last element
		for(String element : resultArray) {
			summation += Integer.parseInt(element);
		}
		// Remove last element
		summation = summation - answer;
		
		// Finally check if summation equals answer (the result of the summation)
		if(summation == answer) {
			// Print solution
			System.out.println(result);
			solutionCount ++;
		}
	}
	
	/** Obtain unique letters[a-zA-Z] in given string
	 * 
	 * @param puzzle the given puzzle that unique letters need to be extracted from
	 * @return an ArrayList of characters containing the unique letters
	 */
	public static ArrayList<Character> obtainUnique(){
		
		ArrayList<Character> letters = new ArrayList<Character>();
		//get unique characters
		for (int i = 0; i < puzzle.length(); i++) {
			char character = puzzle.charAt(i);
			// Check whether the character is already seen and whether character truly matches a-z or A-Z
			// using regular expressions
			if (!letters.contains(character) && Character.toString(character).matches("[a-zA-z]+")) {
				letters.add(character);
			}
		}
		return letters;
		
	}
}
