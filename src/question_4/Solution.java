package question_4;

/** Question 4, Maze
 * 
 * @author Nicky
 *
 */
public class Solution {

	public static void main(String[] args) {

		String[] mzlyt = {
				"*x*******",
				"*     * *",
				"* ***** *",
				"* * *   *",
				"* * *** *",
				"*   *   *",
				"*** * * *",
				"*     * *",
				"*******x*"};

		Maze mz = new Maze(mzlyt);
		mz.solveMaze();
	}

}
