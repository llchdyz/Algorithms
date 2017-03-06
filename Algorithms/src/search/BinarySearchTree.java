package search;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V>, Iterable<K> {
	
	TreeNode root;
	
	public V get(K key) {
		
		return get(root, key);
	}
	
	private V get(TreeNode node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return get(node.left, key);
		}
		else if (cmp > 0) {
			return get(node.right, key);
		}
		else {
			return node.value;
		}
	}
	
	public void put (K key, V value) {
		root = put(root, key, value);
	}
	
	private TreeNode put(TreeNode node, K key, V value) {
		if (node == null) {
			return new TreeNode(key, value, 1);
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		}
		else if (cmp > 0) {
			node.right = put(node.right, key, value);
		}
		else {
			node.value = value;
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	protected int size(TreeNode node) {
		return node == null ? 0 : node.size;
	}
	
	public K getMin() {
		TreeNode node = root;
		K min = null;
		while (node != null) {
			min = node.key;
			node = node.left;
		}
		return min;
	}
	
	public K getMax() {
		TreeNode node = root;
		K max = null;
		while (node != null) {
			max = node.key;
			node = node.right;
		}
		return max;
	}
	
	public int rank(K key) {
		return rank(root, key);
	}
	
	public List<K> rangeSearch(K lo, K hi) {
		List<K> list = new LinkedList<>();
		rangeSearch(root, lo, hi, list);
		return list;
	}
	
	private void rangeSearch(TreeNode node, K lo, K hi, List<K> list) {
		if (node == null) return;
		int loCmp = lo.compareTo(node.key), hiCmp = hi.compareTo(node.key);
		if (loCmp > 0) {
			rangeSearch(node.right, lo, hi, list);
		}
		else if (hiCmp < 0) {
			rangeSearch(node.left, lo, hi, list);
		}
		else {
			list.add(node.key);
			rangeSearch(node.left, lo, hi, list);
			rangeSearch(node.right, lo, hi, list);
		}
	}
	
	/**
	 * number of nodes < key
	 * @param node
	 * @param key
	 * @return
	 */
	private int rank(TreeNode node , K key) {
		if (node == null) {
			return 0;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return size(node.left);
		}
		else if (cmp < 0) {
			return rank(node.left, key);
		}
		else {
			return size(node.left) + 1 + rank(node.right, key);
		}
	}
	
	public K ceiling(K key) {
		TreeNode node = ceiling(root, key);
		return node == null ? null : node.key;
	}
	
	private TreeNode ceiling(TreeNode node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		}
		else if (cmp < 0) {
			return null;
		}
		else {
			TreeNode right = ceiling(node.right, key);
			return right != null ? right : node;
		}
	}
	
	public K floor(K key) {
		TreeNode node = floor(root, key);
		return node == null ? null : node.key;
	}
	
	private TreeNode floor(TreeNode node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return floor(node.left, key);
		}
		else if (cmp > 0) {
			TreeNode right = floor (node.right, key);
			return right == null ? node : right;
		}
		else { // cmp == 0
			return node;
		}
	}
	
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private TreeNode delete(TreeNode node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp > 0) {
			node.right = delete(node.right, key);
		}
		else if (cmp < 0) {
			node.left = delete(node.left, key);
		}
		else {			
			if (node.left == null) {
				node = node.right;
			}
			else if (node.right == null) {
				node = node.left;
			}
			else {
				// has both left and right child
				// find the min node of the right
				TreeNode min = getMin(node.right);
				min.right = deleteMin(node.right);
				min.left = node.left;
				node = min;
			}
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	
	private TreeNode deleteMin(TreeNode node) {
		assert(node != null);
		
		if (node.left == null) {
			return null;
		}
		else {
			return deleteMin(node.left);
		}	
	}
	
	private TreeNode getMin(TreeNode node) {
		assert(node != null);
		
		if (node.left == null) {
			return node;
		}
		else {
			return getMin(node.left);
		}
	}
	
	public int size() {
		return size(root);
	}
	
	class TreeNode {
		K key;
		V value;
		int size = 0;
		private TreeNode left;
		private TreeNode right;
		
		TreeNode(K key, V value) {
			this.key = key;
			this.value = value;
			size = 1;
		}
		
		TreeNode(K key, V value, int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}	
		
	}

	
	public Iterable<K> keys(TraverseOrder order) {
		switch (order) {
			case INORDER: return traverseInOrder();
			case POSTORDER: return traversePostOrder();
			case PREORDER: return traversePreOrder();
			default : return null;
		}

	}
	
	public Iterable<K> keysRecusive(TraverseOrder order) {
		switch (order) {
			case INORDER: return traverseInOrderRecursive();
			case POSTORDER: return traversePostOrderRecursive();
			case PREORDER: return traversePreOrderRecursive();
			default : return null;
		}

	}
	
	private Queue<K> traverseInOrderRecursive() {
		Queue<K> queue = new LinkedList<K>();
		traverseInOrderRecursive(root, queue);
		return queue;
	}
	
	private void traverseInOrderRecursive(TreeNode node, Queue<K> queue) {
		if (node == null) {
			return;
		}
		
		traverseInOrderRecursive(node.left, queue);
		queue.add(node.key);
		traverseInOrderRecursive(node.right, queue);
	}
	
	private Queue<K> traversePreOrderRecursive() {
		Queue<K> queue = new LinkedList<K>();
		traversePreOrderRecursive(root, queue);
		return queue;
	}
	
	private void traversePreOrderRecursive(TreeNode node, Queue<K> queue) {
		if (node == null) {
			return;
		}
		queue.add(node.key);
		traversePreOrderRecursive(node.left, queue);
		traversePreOrderRecursive(node.right, queue);
	}
	
	private Queue<K> traversePostOrderRecursive() {
		Queue<K> queue = new LinkedList<K>();
		traversePostOrderRecursive(root, queue);
		return queue;
	}
	
	private void traversePostOrderRecursive(TreeNode node, Queue<K> queue) {
		if (node == null) {
			return;
		}
		traversePostOrderRecursive(node.left, queue);
		traversePostOrderRecursive(node.right, queue);
		queue.add(node.key);
	}
	
	
	private Queue<K> traverseInOrder() {
		if (root == null) {
			return null;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		Queue<K> queue = new LinkedList<>();
		TreeNode cur = root;
		boolean flag = true;
		while (flag) {
			stack.push(cur);
			if (cur.left != null) {
				cur = cur.left;
			}
			else {
				while (true) {
					// visit when pop out
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					cur = stack.pop();
					queue.add(cur.key);
					if (cur.right != null) {
						cur = cur.right;
						break;
					}
				}
			}
		}
		return queue;
	}
	
	private Queue<K> traversePreOrder() {
		if (root == null) {
			return null;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		Queue<K> queue = new LinkedList<>();
		stack.push(root);
		TreeNode cur;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			// visit first
			queue.add(cur.key);
			// push right (next starting point)
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		return queue;
	}
	
	private Queue<K> traversePostOrder() {
		if (root == null) {
			return null;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		Queue<K> queue = new LinkedList<>();
		TreeNode cur = root, prev = null; 
		while (true) {
			stack.push(cur);
			if (cur.left != null) {
				cur = cur.left;
			}
			else {
				while (!stack.isEmpty()){
					cur = stack.peek();
					if (cur.right == null || cur.right == prev) {// cur.rigth == prev is the key
						prev = cur;
						cur = stack.pop();
						// visit it after pop (need to check left, right before we can pop it)
						queue.add(cur.key);
					}
					else {
						cur = cur.right;
						break;// exit inner loop
					}
				}
				if (stack.isEmpty()) {
					break;// exit outer loop
				}
			}
		}
		return queue;
	}
	
	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return new BSTIterator();
	}
	
	private class BSTIterator implements Iterator<K> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
