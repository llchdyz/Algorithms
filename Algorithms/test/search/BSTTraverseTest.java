package search;


import org.junit.Test;

public class BSTTraverseTest {
	@Test
	public void testTreeTraverse() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
		TraverseOrder order = TraverseOrder.INORDER;
		Iterable<Integer> iterative = tree.keys(order);
		Iterable<Integer> recursive = tree.keysRecusive(order);

		
		tree.put(1,"test");
		iterative = tree.keys(order);
		recursive = tree.keysRecusive(order);
		assert(recursive.toString().equals(iterative.toString()));
		System.out.println(iterative.toString());
		System.out.println(recursive.toString());
		
		tree.put(3, "test");
		tree.put(6,"test");
		tree.put(9, "test");
		tree.put(7,"test");
		
		iterative = tree.keys(order);
		recursive = tree.keysRecusive(order);
		assert(recursive.toString().equals(iterative.toString()));
		System.out.println(iterative.toString());
		System.out.println(recursive.toString());
		
		tree.put(8, "test");
		tree.put(10,"test");
		tree.put(20, "test");
		
		iterative = tree.keys(order);
		recursive = tree.keysRecusive(order);
		assert(recursive.toString().equals(iterative.toString()));
		System.out.println(iterative.toString());
		System.out.println(recursive.toString());

	}
}
