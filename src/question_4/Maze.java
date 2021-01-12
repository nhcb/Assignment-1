package question_4;
import question_4.Field;

/** Maze class that represents a maze given in string form.
 * 
 * @author Nicky
 *
 */
public class Maze{
	private Field[][] fields;
	private int startX,startY;
	private int lenX,lenY;
	
	/** Constructor for the maze
	 * 
	 * @param layout an Array containing the layout of the maze, each element represents a row in the maze

	 */
	public Maze(String[] layout) {
		// Generate the maze
		this.generateMaze(layout);
	}
	
	/** Method to generate the maze from a String[] layout
	 * 
	 * @param layout an Array containing the layout of the maze, each element represents a row in the maze
	 */
	private void generateMaze(String[] layout) {
		lenX = layout.length;
		lenY = layout[0].split("").length;
		// Create a field of the maze
		fields = new Field[lenX][lenY];
		
		// Extract information from the maze layout
		// Introduce a row counter and column counter
		int rowCounter=0;
		int colCounter=0;
		// Introduce a boolean that determines whether x should be a starting or ending position
		boolean position=false;
		for(String row : layout) {
			colCounter =0;
			// Each element represents a character of the row
			for(String element : row.split("")) {
				// Create field
				fields[colCounter][rowCounter] = new Field();				
				// Determine whether element is a wall, start or end.
				if(element.equals("*")) {
					fields[colCounter][rowCounter].makeWall(true);
				}
				if(element.equals("x")) {
					// X not visited yet, make it start position
					if(!position) {
						position = true;
						// Save the starting position
						startX = colCounter;
						startY = rowCounter;
						
					}
					// X already visited, make it end position
					else {
						fields[colCounter][rowCounter].makeEnd(true);
					}
				}
				colCounter++;
			}
			rowCounter++;
		}
	}
	/** Method that recursively solves the maze, starts from the starting position
	 * 
	 */
	public void solveMaze() {
		
		// Start solving the maze from start position, hence visit this field
		fields[startX][startY].makeVisit(true);
		// Make one-step moves rightward (1), upward (2), leftward (3) and downward (4)
		// These one-step moves should remain in the bounds of the maze and not be a wall
		
		// rightward (1)
		if(startX+1 < lenX && !fields[startX+1][startY].isWall()) {
			fields[startX][startY].makeMove(1);
			solveMaze(startX+1,startY,fields);
			// Remove move from fields
			fields[startX][startY].makeMove(-1);
		}
		// upward (2)
		if(startY-1 < lenY && startY-1 >= 0 &&  !fields[startX][startY-1].isWall()) {
			fields[startX][startY].makeMove(2);
			solveMaze(startX,startY-1,fields);
			// Remove move from fields
			fields[startX][startY].makeMove(-1);
		}
		// leftward (3)
		if(startX-1 < lenX && startX-1 >= 0 && !fields[startX-1][startY].isWall()) {
			fields[startX][startY].makeMove(3);
			solveMaze(startX-1,startY,fields);
			// Remove move from fields
			fields[startX][startY].makeMove(-1);
		}
		// downward (4)
		if(startY+1 < lenY && !fields[startX][startY+1].isWall()) {
			fields[startX][startY].makeMove(4);
			solveMaze(startX,startY+1,fields);
			// No need to remove moves (as this is the last if )
		}
		
	}
	/** Method that recursively solves the maze
	 * 
	 * @param x the x-position in the matrix representing the maze
	 * @param y the y-position in the matrix representing the maze
	 * @param updatedFields the matrix that represents the maze, uses Field objects.
	 */
	private void solveMaze(int x, int y,Field[][] updatedFields) {
		// Check whether current coordinates are end coordinates
		if(updatedFields[x][y].isEnd()) {
			// Done solving, print result...
			fields = updatedFields;
			this.getSolution();
			return;
		}
		else {
			// Visit this field
			updatedFields[x][y].makeVisit(true);
			// Make one-step moves rightward (1), upward (2), leftward (3) and downward (4)
			// These one-step moves should remain in the bounds of the maze and not be a wall
			// Furthermore we do not wish to visit previously visited fields
			
			// rightward (1)
			if(x + 1 < lenX && !updatedFields[x+1][y].isWall() && !updatedFields[x+1][y].isVisited()) {
				updatedFields[x][y].makeMove(1);
				solveMaze(x+1,y,updatedFields);
				// Remove move from updatedFields
				updatedFields[x][y].makeMove(-1);
			}
			// upward (2)
			if(y - 1 < lenY && y-1 >= 0 && !updatedFields[x][y-1].isWall() && !updatedFields[x][y-1].isVisited()) {
				updatedFields[x][y].makeMove(2);
				solveMaze(x,y-1,updatedFields);
				// Remove move from updatedFields
				updatedFields[x][y].makeMove(-1);
			}
			// leftward (3)
			if(x-1 < lenX && x-1 >= 0 && !updatedFields[x-1][y].isWall() && !updatedFields[x-1][y].isVisited()) {
				updatedFields[x][y].makeMove(3);
				solveMaze(x-1,y,updatedFields);
				// Remove move from updatedFields
				updatedFields[x][y].makeMove(-1);
			}
			// downward (4)
			if(y + 1 < lenY  && !updatedFields[x][y+1].isWall() && !updatedFields[x][y+1].isVisited()) {
				updatedFields[x][y].makeMove(4);
				solveMaze(x,y+1,updatedFields);
				// No need to remove move from updatedFields
			}
			
		}
		
	}
	/** Method that prints the maze with the (correct) moves
	 * 
	 */
	private void getSolution() {
		for(int i =0;i < lenY; i ++) {
			for(int j = 0 ; j < lenX; j ++) {
				System.out.print(fields[j][i]);
			}
			System.out.println();
		}
	}
}
