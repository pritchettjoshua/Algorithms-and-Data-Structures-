public class Tree<T extends Comparable<T>, E> extends Node<T, E> {
	private Node<T, E> root; // the root of the tree
	private Node<T, E> cursor; // the current node
	private Node<T, E> none = new Node<T, E>();

	public void toRoot() {
		cursor = root;
	}

	public Node<T, E> getRoot() {
		return root;
	}

	public void setRoot(Node<T, E> newRoot) {
		root = newRoot;
	}

	public Node<T, E> getCursor() {
		return cursor;
	}

	public void setCursor(Node<T, E> newCursor) {
		cursor = newCursor;
	}

	public boolean hasLeftChild() {
		return cursor.getLeft() != null;
	}

	public boolean hasRightChild() {
		return cursor.getRight() != null;
	}

	public void toLeftChild() {
		cursor = cursor.getLeft();
	}

	public void toRightChild() {
		cursor = cursor.getRight();
	}

	public T get() {
		return cursor.getKey();
	}

	public void set(T data) {
		cursor.setKey(data);
	}

	public int height() {
		if (root != null) {
			return root.height();
		} else {
			return 0;
		}
	}

	public String toString() {
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}

	public void LeftRotate(Node<T, E> x) {
		Node<T, E> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != none) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == none || x.getParent() == null) {
			this.setRoot(y);
		} else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}

	public void RightRotate(Node<T, E> x) {
		Node<T, E> y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != none) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == none || x.getParent() == null) {
			this.setRoot(y);
		} else if (x == x.getParent().getRight()) {
			x.getParent().setRight(y);
		} else
			x.getParent().setLeft(y);
		y.setRight(x);
		x.setParent(y);
	}

	public void Insert(T key, E value) {
		Node<T, E> temp = new Node<T, E>();
		temp.setKey(key);
		temp.setValue(value);
		RedBlackInsert(temp);
	}

	public String TreeSearch(T key) {
		String result;
		Node<T, E> temp = this.getRoot();
		temp = RedBlackSearch(temp, key);
		if (temp != null && temp != none) {
			System.out.println((String) temp.getValue());
			String b = (String) temp.getValue();
			result = key + "  : " + b;
		} else {
			result = "Key not found : " + key;
		}
		return result;
	}

	public void RedBlackInsert(Node<T, E> z) {
		if (this.getRoot() == null) {
			this.setRoot(z);
			z.setLeft(none);
			z.setRight(none);
			z.setColor(true);
			RedBoackInsertFixup(z);
		} else {
			Node<T, E> y = none;
			Node<T, E> x = this.getRoot();
			while (x != none) {
				y = x;
				if (z.getKey().compareTo(x.getKey()) < 0) {
					x = x.getLeft();
				} else {
					x = x.getRight();
				}
			}
			z.setParent(y);
			if (y == none) {
				this.setRoot(z);
			} else if (z.getKey().compareTo(y.getKey()) < 0) {
				y.setLeft(z);
			} else {
				y.setRight(z);
			}

			z.setLeft(none);
			z.setRight(none);
			z.setColor(true);
			RedBoackInsertFixup(z);
		}
	}

	public void RedBoackInsertFixup(Node<T, E> z) {
		Node<T, E> y = none;
		while (z != null && z.getParent() != null
				&& z.getParent().getParent() != null
				&& z.getParent().getColor() == true) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				if (y.getColor() == true) {
					z.getParent().setColor(false);
					y.setColor(false);
					z.getParent().getParent().setColor(true);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						LeftRotate(z);
					}
					z.getParent().setColor(false);
					z.getParent().getParent().setColor(true);
					RightRotate(z.getParent().getParent());
				}
			} else if (z.getParent() == z.getParent().getParent().getRight()) {
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == true) {
					z.getParent().setColor(false);
					y.setColor(false);
					z.getParent().getParent().setColor(true);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						RightRotate(z);
					}
					z.getParent().setColor(false);
					z.getParent().getParent().setColor(true);
					LeftRotate(z.getParent().getParent());
				}
			}
		}
		this.getRoot().setColor(false);
	}

	public void Traversal() {
		Node<T, E> temp = getRoot();
		InorderTreeWalk(temp);
	}

	public void InorderTreeWalk(Node<T, E> x) {
		if (x != null && x != none) {
			InorderTreeWalk(x.getLeft());
			System.out.print(x.getKey() + "  ");
			InorderTreeWalk(x.getRight());
		}
	}

	public Node<T, E> RedBlackSearch(Node<T, E> temp, T key) {
		if (key.compareTo(temp.getKey()) < 0) {
			return RedBlackSearch(temp.getLeft(), key);
		} else if (key.compareTo(temp.getKey()) > 0) {
			return RedBlackSearch(temp.getRight(), key);
		} else
			return temp;
	}
}
