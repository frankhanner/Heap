package ds;

public class TreeNode {
	private int value;
	private TreeNode leftChild, rightChild;
	
	TreeNode(int value){
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	int getValue(){
		return this.value;
	}
	
	TreeNode getRightChild(){
		return this.rightChild;
	}
	
	TreeNode getLeftChild(){
		return this.leftChild;
	}
}
