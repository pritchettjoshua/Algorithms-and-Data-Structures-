public class RBNode<T extends Comparable<? super T>> {
	private RBNode<T> parent; // the parent of this Node
	private T data; // the data in this node
	private RBNode<T> left; // the left child
	private RBNode<T> right; // the right child
	private boolean color;

	public RBNode() {
		this(null, null, null, null, false);
	}

	public RBNode(T theData) {
		this(null, theData, null, null, true);
	}

	public RBNode(RBNode<T> theParent, T theData, RBNode<T> leftChild,
			RBNode<T> rightChild, boolean theColor) {
		data = theData;
		left = leftChild;
		right = rightChild;
		parent = theParent;
		color = theColor;
	}

	public T getData() {
		return data;
	}

	public RBNode<T> getParent() {
		return parent;
	}

	public RBNode<T> getLeft() {
		return left;
	}

	public RBNode<T> getRight() {
		return right;
	}

	public void setLeft(RBNode<T> newLeft) {
		left = newLeft;
	}

	public void setRight(RBNode<T> newRight) {
		right = newRight;
	}

	public void setParent(RBNode<T> newParent) {
		parent = newParent;
	}

	public void setData(T newData) {
		data = newData;
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
		String treeString = pathString + " : " + data + "   " + color + "\n";

		if (left != null && left.getData() != null) {
			treeString += left.toStringPreOrder(pathString + "L");
		}

		if (right != null && right.getData() != null) {
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
