package sort;

public class MergeSort<T extends Comparable<T>> {
	public void sort(T[] a) {
		if (a.length == 0) return;
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[a.length];
		sort(a, aux, 0, a.length-1);
	}
	
	private void sort(T[] a, T[] aux, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int mid = (low + high) / 2;
		sort(a, aux, low, mid);
		sort(a, aux, mid+1, high);
		
		for (int i = low; i <= high; i++ ) {
			aux[i] = a[i];
		}
		int i = low, j = mid+1, k = low;
		while (k <= high) {
			if (i > mid) {
				a[k++] = aux[j++];
			}
			else if (j > high) {
				a[k++] = aux[i++];
			}
			else if (SortHelper.less(aux[i], aux[j])) {
				a[k++] = aux[i++];
			}
			else {
				a[k++] = aux[j++];
			}
		}
	}
}
