package common;

public class TreeNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	int size = 0;
	protected TreeNode<K, V> left;
	protected TreeNode<K, V> right;
	
	public TreeNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public TreeNode(K key, V value, int size) {
		this.key = key;
		this.value = value;
		this.size = size;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return size;
	}
	
	public K getKey() {
		return key;
	}
	
	
}
