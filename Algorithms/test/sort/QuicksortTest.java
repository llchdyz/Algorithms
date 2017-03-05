package sort;

import java.util.Arrays;

import org.junit.Test;

import sort.QuickSort;

public class QuicksortTest {

	@Test
	public void testEmptyInput() {
		Integer[] intArr = new Integer[]{};
		Integer[] intArrCopy = intArr.clone();
		new QuickSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testSingleInput() {
		Integer[] intArr = new Integer[]{1};
		Integer[] intArrCopy = intArr.clone();
		new QuickSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testMultipleInput() {
		Integer[] intArr = new Integer[]{3, 2, 5, 6, 2, 1, 8, 9};
		
		
		Integer[] intArrCopy = intArr.clone();
		new QuickSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
			System.out.println(intArr[i]);
		}
	}


}
