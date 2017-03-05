package sort;

public class InsertionSort<T extends Comparable<T>> {
	
	public void sort(T[] arrInput) {
		int arrLength = arrInput.length;
		
		if (arrLength == 0) {
			return;
		}
		
		for (int i = 0; i < arrLength; i++) {
			for (int j = i ; j > 0; j--) {
				if (SortHelper.less(arrInput[j], arrInput[j-1])) {
					SortHelper.swap(arrInput, j, j-1);
				}
			}
		}
	}
}
