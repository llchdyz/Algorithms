package sort;

import java.util.Comparator;

public class SortHelper {
	
	public static <T extends Comparable<T>> void swap (T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static <T extends Comparable<T>> boolean less (T a, T b) {
		return a.compareTo((T) b) < 0;
	}
	
	public static <T> boolean less (Comparator<T> cmp, T a, T b) {
		return cmp.compare(a, b) < 0;
	}
}
