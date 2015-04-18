public class RBTree<T extends Comparable<T>> extends RBNode<T> {
	private RBNode<T> root; // the root of the tree
	private RBNode<T> cursor; // the current node
	private RBNode<T> none = new RBNode<T>();

	public void toRoot() {
		cursor = root;
	}

	public RBNode<T> getRoot() {
		return root;
	}

	public void setRoot(RBNode<T> newRoot) {
		root = newRoot;
	}

	public RBNode<T> getCursor() {
		return cursor;
	}

	public void setCursor(RBNode<T> newCursor) {
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
		return cursor.getData();
	}

	public void set(T data) {
		cursor.setData(data);
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

	public void LeftRotate(RBNode<T> x) {
		RBNode<T> y = x.getRight();
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

	public void RightRotate(RBNode<T> x) {
		RBNode<T> y = x.getLeft();
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

	public void Insert(T data) {
		RBNode<T> temp = new RBNode<T>(data);
		RedBlackInsert(temp);
	}

	public T Search(T key) {
		RBNode<T> temp = this.getRoot();
		temp = RedBlackSearch(temp, key);
		return temp.getData();
	}

	public void RedBlackInsert(RBNode<T> z) {
		if (this.getRoot() == null) {
			this.setRoot(z);
			z.setLeft(none);
			z.setRight(none);
			z.setColor(true);
			RedBoackInsertFixup(z);
		} else {
			RBNode<T> y = none;
			RBNode<T> x = this.getRoot();
			while (x != none) {
				y = x;
				if (z.getData().compareTo(x.getData()) < 0) {
					x = x.getLeft();
				} else {
					x = x.getRight();
				}
			}
			z.setParent(y);
			if (y == none) {
				this.setRoot(z);
			} else if (z.getData().compareTo(y.getData()) < 0) {
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

	public void RedBoackInsertFixup(RBNode<T> z) {
		RBNode<T> y = none;
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
		RBNode<T> temp = getRoot();
		InorderTreeWalk(temp);
	}

	public void InorderTreeWalk(RBNode<T> x) {
		if (x != null && x != none) {
			InorderTreeWalk(x.getLeft());
			System.out.print(x.getData() + "  ");
			InorderTreeWalk(x.getRight());
		}
	}

	public RBNode<T> RedBlackSearch(RBNode<T> temp, T key) {
		if (temp.getData() == null || temp.getData() == key)
			return temp;
		if (key.compareTo(temp.getData()) < 0)
			return RedBlackSearch(temp.getLeft(), key);
		else
			return RedBlackSearch(temp.getRight(), key);

	}

}
