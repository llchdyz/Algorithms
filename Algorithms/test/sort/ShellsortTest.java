package sort;

import java.util.Arrays;

import org.junit.Test;

import sort.Shellsort;

public class ShellsortTest {

	@Test
	public void testEmptyInput() {
		Integer[] intArr = new Integer[]{};
		Integer[] intArrCopy = intArr.clone();
		new Shellsort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testSingleInput() {
		Integer[] intArr = new Integer[]{1};
		Integer[] intArrCopy = intArr.clone();
		new Shellsort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
		}
	}
	
	@Test
	public void testMultipleInput() {
		Integer[] intArr = new Integer[]{3, 2, 5, 6};
		
		
		Integer[] intArrCopy = intArr.clone();
		new Shellsort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
			System.out.println(intArr[i]);
		}
	}
	
	@Test
	public void testLargeInput() {
		Integer[] intArr = new Integer[]{3, 2, 5, 6, 1, 5, 3, 3, 6, 9};
		
		
		Integer[] intArrCopy = intArr.clone();
		new Shellsort<Integer>().sort(intArr);

		Arrays.sort(intArrCopy);
		for (int i = 0; i < intArr.length; i++) {
			assert(intArr[i] == intArrCopy[i]);
			System.out.println(intArr[i]);
		}
	}

}
