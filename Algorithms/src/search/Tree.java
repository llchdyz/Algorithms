package search;

public interface Tree<K, V> {
	public V get(K key);
	public void put(K key, V value);
}
