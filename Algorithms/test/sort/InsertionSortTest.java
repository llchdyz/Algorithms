package sort;

import java.util.Arrays;

import org.junit.Test;

import sort.InsertionSort;

public class InsertionSortTest {

	@Test
	public void testEmptyInput() {
		Integer[] intArr = new Integer[]{};
		Integer[] intArrCopy = intArr.clone();
		new InsertionSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testSingleInput() {
		Integer[] intArr = new Integer[]{1};
		Integer[] intArrCopy = intArr.clone();
		new InsertionSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testMultipleInput() {
		Integer[] intArr = new Integer[]{3, 2, 5, 6};
		
		
		Integer[] intArrCopy = intArr.clone();
		new InsertionSort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
			System.out.println(intArr[i]);
		}
	}

}
