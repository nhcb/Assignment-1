package question_3;

/** Tree class that represents a binary tree of general height
 * 
 * @author Nicky
 *
 */
public class Tree {

	private Node[] nodes;
	
	/** Constructor for a tree of general height
	 * 
	 * @param height the height of the tree
	 */
	public Tree(int height) {
		// The number of nodes from a binary tree with general height h equals 2^(h+1)-1
		int amountNodes = (int) Math.pow(2, height+1 ) - 1;
		// Create an array that holds all the nodes in the tree
		nodes = new Node[amountNodes];
		// Create a loop that creates a tree from the bottom up
		for(int i = amountNodes -1 ; i >=0;i--) {
			
			// If the current loop iterate >= (amountNodes-1)/2, the node is still on the last row of the tree
			// Hence it has no children yet
			if(i >= (amountNodes-1)/2) {
				nodes[i] = new Node(i);
			}
			// Node is not on the last row anymore and hence it has children
			// The children of node n are 2n+1 (left) and 2n+2 (right)
			else {
				nodes[i] = new Node(i,nodes[2*i+1],nodes[2*i+2]);
			}
		}
	}
	/** Print nodes from current tree, print from rootnode of tree
	 * 
	 */
	public void printNodes() {
		// Print from rootNode, this is on index 0 in nodes[]
		nodes[0].printNodes(nodes[0],"");
	}
}
