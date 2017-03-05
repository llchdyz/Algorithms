package sort;

import java.util.Comparator;

public class Shellsort<T extends Comparable<T>> {
	
	public void sort (T[] arrInput) {
		// validation
		int arrLength = arrInput.length;
		if (arrLength == 0) {
			return;
		}
		
		// generate h
		int h = 1;
		while (3 * h + 1 < arrLength) {
			h = 3 * h + 1;
		}
		
		while (h > 0) {
			// do insertion sort
			for (int i = 0; i < arrLength; i++ ) {
				for (int j = i; j - h >= 0; j -= h) {
					if (SortHelper.less(arrInput[j], arrInput[j-h])) {
						SortHelper.swap(arrInput, j, j-h);
					}
				}
			}
			h /= 3;
		}

	}
	
	public void sort (T[] arrInput, Comparator<T> cmp) {
		// validation
		int arrLength = arrInput.length;
		if (arrLength == 0) {
			return;
		}
		
		// generate h
		int h = 1;
		while (3 * h + 1 < arrLength) {
			h = 3 * h + 1;
		}
		
		while (h > 0) {
			// do insertion sort
			for (int i = 0; i < arrLength; i++ ) {
				for (int j = i; j - h >= 0; j -= h) {
					if (SortHelper.less(cmp, arrInput[j], arrInput[j-h])) {
						SortHelper.swap(arrInput, j, j-h);
					}
				}
			}
			h /= 3;
		}
	}
}
