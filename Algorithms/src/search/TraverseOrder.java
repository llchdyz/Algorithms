package search;

public enum TraverseOrder {
	INORDER(0), 
	PREORDER(1),
	POSTORDER(2);
	
	int code;
	
	TraverseOrder(int code) {
		this.code = code;
	}
	
}
