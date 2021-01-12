package question_3;

/** Node class that represents nodes from binary tree
 * 
 * @author Nicky
 *
 */
public class Node {
	private int value;
	private Node left;
	private Node right;

	/** Constructor for the Node
	 *
	 * @param value: the value of the Node
	 */
	public Node(int value){
		this.value = value;
	}

	/** Constructor for the Node
	 *
	 * @param value: the value of the Node
	 * @param left: the Node on this Node's left
	 * @param right: the Node on this Node's right
	 */
	public Node(int value,Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	/** Getter for value
	 * 
	 * @return this node's value
	 */
	public int getValue() {
		return value;
	}
	
	/** Getter for left node's child
	 * 
	 * @return this node's left child
	 */
	public Node getLeft() {
		return left;
	}
	
	/** Getter for right node's child
	 * 
	 * @return this node's right child
	 */
	public Node getRight() {
		return right;
	}


	/** Node printer in tree-form
	 *
	 * @param Node the current node of the tree
	 * @param s the current branch of the tree
	 */
	public void printNodes(Node node, String s) {
		System.out.println(node.getValue());
		s = s + "|----";
		// Recursively go through left side of the node
		if(node.getLeft()!=null) {
			System.out.print(s);
			printNodes(node.getLeft(),s);
		}
		// Recursively go through right side
		if(node.getRight()!=null) {
			System.out.print(s);
			printNodes(node.getRight(),s);
		}
	}
}
