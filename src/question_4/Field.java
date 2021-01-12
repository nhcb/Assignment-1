package question_4;

/** Field class that represents a 1x1 field from Maze class 
 * 
 * @author Nicky
 *
 */
public class Field {
	private boolean wall;
	private boolean end;
	private boolean visited;
	private int move = -1;
	
	/** Constructor for the field, assumes field is not a wall, end or already visited
	 * 
	 */
	public Field() {
		 wall=false;
		 end=false;
		 visited=false;
		 move = -1;

	}
	/** Setter for wall
	 * 
	 * @param bool sets wall to true or false
	 */
	public void makeWall(boolean bool) {
		wall = bool;
	}
	/** Getter for wall
	 * 
	 * @return boolean whether field is wall or not
	 */
	public boolean isWall(){
		return wall;
	}
	/** Setter for end
	 * 
	 * @param bool sets end to either true or false
	 */
	public void makeEnd(boolean bool) {
		end = bool;
	}
	/** Getter for end
	 * 
	 * @return boolean whether field is end or not
	 */
	public boolean isEnd() {
		return end;
	}
	/** Setter for visit
	 * 
	 * @param bool that implies if field is already visited
	 */
	public void makeVisit(boolean bool) {
		visited = bool;
	}
	/** Getter for visit
	 * 
	 * @return boolean that implies wheter field is already visited or not
	 */
	public boolean isVisited() {
		return visited;
	}
	/** Setter for move
	 * 
	 * @param move which move the recursive solver has undertaken
	 */
	public void makeMove(int move) {
		this.move = move;
	}
	
	/** Method that changes regular toString() to a string that more suits our application
	 * 
	 */
	public String toString() {
		if(this.wall) {
			return "*";
		}
		if(this.end) {
			return "x";
		}
		if(this.move==-1) {
			return " ";
		}
		else return Integer.toString(this.move);
		
	}
}

