package search;

public class RedBlackBST<K extends Comparable<K>, V> extends BinarySearchTree<K, V>{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	RBTreeNode root;
	
	public void put(K key, V value) {
		put(root, key, value);
	}
	
	public RBTreeNode put(RBTreeNode node, K key, V value) {
		if (node == null) {
			return new RBTreeNode(key, value, RED);
		}
		int cmp = key.compareTo(node.key);
		if (cmp > 0) {
			node.right = put(node.right, key, value);
		}
		else if (cmp < 0) {
			node.left = put(node.left, key, value);
		}
		else {
			node.value = value;
		}
		// deal with color
		// case 1: insert into '2' node; 1.a larger; 1.b smaller 
		// case 2: insert into '3' node; 2.a larger; 2.b between; 2.c smaller
		if (isRed(node.right) && !isRed(node.left)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.right) && isRed(node.left)){
			node = flipColor(node);
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	private boolean isRed(RBTreeNode node) {
		if (node == null) {
			return false;
		}
		else {
			return node.color == RED;
		}
	}
	
	private RBTreeNode rotateRight(RBTreeNode node) {
		RBTreeNode next = node.right;
		node.right = next.left;
		next.left = node;
		node.color = RED;
		next.color = BLACK;
		return next;
	}
	
	private RBTreeNode rotateLeft(RBTreeNode node) {
		RBTreeNode next = node.left;
		node.left = next.right;
		next.right = node;
		node.color = RED;
		next.color = BLACK;
		return next;
	}
	
	private RBTreeNode flipColor(RBTreeNode node) {
		assert(node.left != null);
		assert(node.right != null);
		
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
		return node;
	}
	
	class RBTreeNode extends TreeNode {
		RBTreeNode left;
		RBTreeNode right;
		boolean color;
		
		RBTreeNode(K key, V value) {
			super(key, value);
		}
		
		RBTreeNode(K key, V value, boolean color) {
			super(key, value);
			this.color = color;
		}
	}
}
