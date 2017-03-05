package sort;

public class PriorityQueue<T extends Comparable<T>> {
	final int capacity;
	T[] a;
	int cur;
	int size;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int N) {
		a = (T[]) new Object[N + 1];
		capacity = N;
		cur = 0;
		size = 0;
	}
	
	public int getSize() {
		return cur;
	}
	
	private void increasePointer() {
		cur++;
	}
	
	private void decreasePointer() {
		cur--;
	}
	
	private int currentPointer() {
		return cur;
	}
	
	// try not to access cur directly 
	public void insert(T item) throws Exception {
		if (getSize() == capacity) {
			throw new Exception();
		}
		increasePointer();
		a[currentPointer()] = item;
		swim(currentPointer());
	}
	
	public T getMin() {
		return a[1];
	}
	
	public T deleteMin() throws Exception {
		if (size == 0) {
			throw new Exception();
		}
		T min = a[1];
		SortHelper.swap(a, 1, cur--);
		sink(1);
		a[cur+1] = null;
		return min;
	}
	
	
	private void swim( int k) {
		while (k > 1 && SortHelper.less(a[k], a[k/2])) {
				SortHelper.swap(a, k, k/2);
				k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2 * k < capacity) {
			int j = 2 * k;
			if (j < capacity && SortHelper.less(a[j+1], a[j])) {
				j++;
			}
			if (SortHelper.less(a[k], a[j])) {
				break;	
			}
			SortHelper.swap(a, k, j);
			k = j;
		}
	}
	
}
