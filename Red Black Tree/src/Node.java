public class Node<T extends Comparable<? super T>, E> {
	private Node<T, E> parent; // the parent of this Node
	private T key; // the data in this node
	private E value;
	private Node<T, E> left; // the left child
	private Node<T, E> right; // the right child
	private boolean color;

	public Node() {
		this(null, null, null, null, null, false);
	}

	public Node(T theKey) {
		this(null, theKey, null, null, null, true);
	}

	public Node(Node<T, E> theParent, T theKey, E theValue,
			Node<T, E> leftChild, Node<T, E> rightChild, boolean theColor) {
		key = theKey;
		value = theValue;
		left = leftChild;
		right = rightChild;
		parent = theParent;
		color = theColor;
	}

	public T getKey() {
		return key;
	}

	public E getValue() {
		return value;
	}

	public Node<T, E> getParent() {
		return parent;
	}

	public Node<T, E> getLeft() {
		return left;
	}

	public Node<T, E> getRight() {
		return right;
	}

	public void setLeft(Node<T, E> newLeft) {
		left = newLeft;
	}

	public void setRight(Node<T, E> newRight) {
		right = newRight;
	}

	public void setParent(Node<T, E> newParent) {
		parent = newParent;
	}

	public void setKey(T newKey) {
		key = newKey;
	}

	public void setValue(E newValue) {
		value = newValue;
	}

	public int height() {
		int leftHeight = 0; // Height of the left subtree
		int rightHeight = 0; // Height of the right subtree
		int height = 0; // The height of this subtree

		// If we have a left subtree, determine its height
		if (left != null) {
			leftHeight = left.height();
		}

		// If we have a right subtree, determine its height
		if (right != null) {
			rightHeight = right.height();
		}

		// The height of the tree rooted at this node is one more than the
		// height of the 'taller' of its children.
		if (leftHeight > rightHeight) {
			height = 1 + leftHeight;
		} else {
			height = 1 + rightHeight;
		}

		// Return the answer
		return height;
	}

	public String toStringPreOrder(String pathString) {
		String treeString = pathString + " : " + key + "   " + color + "\n";

		if (left != null && left.getKey() != null) {
			treeString += left.toStringPreOrder(pathString + "L");
		}

		if (right != null && right.getKey() != null) {
			treeString += right.toStringPreOrder(pathString + "R");
		}

		return treeString;
	}

	public void setColor(boolean newColor) {
		color = newColor;
	}

	public boolean getColor() {
		return color;
	}
}
