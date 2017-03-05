package sort;


public class QuickSort<T extends Comparable<T>> {
	
	public void sort(T[] input) {
		// shuffle
		// sort
		sort(input, 0, input.length-1);
	}
	
	private void sort(T[] array, int low, int high) {
		if (low >= high) return;
		int k = partition(array, low, high);
		sort(array, low, k);
		sort(array, k+1, high);
	}
	
	private int partition(T[] array, int low, int high) {
		int i = low, j = high + 1;
		while (true) {
			// find first one larger than k; or hit the high
			while (SortHelper.less(array[++i], array[low])) {
				if (i == high) break;
			}
			
			// find the first one less than k, reversely
			while ( SortHelper.less(array[low], array[--j]));
			
			if (i < j) {
				SortHelper.swap(array, i, j);
			}
			else {
				SortHelper.swap(array, low, j);
				break;
			}
		}

		return j;
	}
}

