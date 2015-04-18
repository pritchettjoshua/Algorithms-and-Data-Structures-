import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>>{
	private BinaryTreeNode<T> root; // the root of the tree
	private BinaryTreeNode<T> cursor; // the current node
	private Comparator<T> comparator;
	

	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	public void toRoot() {
		cursor = root;
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
	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(BinaryTreeNode<T> r) {
		if (r != null) {
			inOrderHelper(r.getLeft());
			System.out.print(r.getData() + " ");
			inOrderHelper(r.getRight());
		}
	}
	public void insert(T data) {
		root = insert(root, data);
	}

	private BinaryTreeNode<T> insert(BinaryTreeNode<T> tree, T toInsert) {
		if (tree == null)
			return new BinaryTreeNode<T>(toInsert);

		if (compare(toInsert, tree.getData()) == 0)
			return tree;

		if (compare(toInsert, tree.getData()) < 0)
			tree.setLeft(insert(tree.getLeft(), toInsert));
		else
			tree.setRight(insert(tree.getRight(), toInsert));

		return tree;
	}
	
	 public boolean search(T toSearch)
	   {
	      return search(root, toSearch);
	   }
	   private boolean search(BinaryTreeNode<T> tree, T toSearch)
	   {
	      if (tree == null)
	         return false;
	      else
	      if (compare(toSearch, tree.getData()) == 0)
	      	return true;
	      else
	      if (compare(toSearch, tree.getData()) < 0)
	         return search(tree.getLeft(), toSearch);
	      else
	         return search(tree.getRight(), toSearch);
	   }
	   
	   public void delete(T toDelete)
	   {
	      root = delete(root, toDelete);
	   }
	   private BinaryTreeNode<T> delete(BinaryTreeNode<T> tree, T toDelete)
	   {
	      if (tree == null)  throw new RuntimeException("can't delete.");
	      else
	      if (compare(toDelete, tree.getData()) < 0)
	      tree.setLeft(delete (tree.getLeft(), toDelete));
	      else
	      if (compare(toDelete, tree.getData())  > 0)
	      tree.setRight(delete (tree.getRight(), toDelete));
	      else
	      {
	         if (tree.getLeft() == null) return tree.getRight();
	         else
	         if (tree.getRight() == null) return tree.getLeft();
	         else
	         {
	            tree.setData(retrieveData(tree.getLeft()));
	            tree.setLeft(delete(tree.getLeft(), tree.getData())) ;
	         }
	      }
	      return tree;
	   }
	   private T retrieveData(BinaryTreeNode<T> tree)
	   {
	      while (tree.getRight() != null) tree = tree.getRight();

	      return tree.getData();
	   }
	}

