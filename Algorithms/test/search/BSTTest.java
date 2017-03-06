package search;

import java.util.List;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testRangeSearch() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

		
		tree.put(1,"test");
		
		tree.put(3, "test");
		tree.put(6,"test");
		tree.put(9, "test");
		tree.put(7,"test");
		
		tree.put(8, "test");
		tree.put(10,"test");
		tree.put(20, "test");
		
		Iterable<Integer> it = tree.keys(TraverseOrder.INORDER);
		System.out.println(it.toString());
		
		List<Integer> list = tree.rangeSearch(2, 5);
		assert(list.size() == 1);
		
		list = tree.rangeSearch(2, 6);
		assert(list.size() == 2);
		
		list = tree.rangeSearch(9, 10);
		assert(list.size() == 2);
		
		
		list = tree.rangeSearch(2, 10);
		assert(list.size() == 6);
	}

}
