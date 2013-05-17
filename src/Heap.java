import java.util.ArrayList;

public class Heap {
	private ArrayList<TreeNode> heap;
	private int size;

	public Heap() {
		this.heap = new ArrayList<TreeNode>();
		this.size = 0;
	}

	public void insert(TreeNode node) {
		// add node to end then sift up in order to maintain heap property
		this.heap.add(node);
		this.size++;
		siftUp(this.size - 1);
	}

	public TreeNode delete() {
		// if size is 0, nothing to remove
		if (this.size == 0) {
			return null;
		}

		// remove max, and replace it with last leaf then sift leaf down
		TreeNode maxNode = this.heap.remove(0);
		this.size--;
		TreeNode lastLeaf = this.heap.remove(this.size - 1);
		this.heap.add(0, lastLeaf);
		siftDown(0);

		return maxNode;
	}

	private void siftUp(int index) {
		// if first node it's already at top
		if (index == 0) {
			return;
		}

		// take current node and compare to parent
		int parentIndex = (index - 1) / 2;
		TreeNode current = this.heap.get(index);
		TreeNode parent = this.heap.get(parentIndex);

		// if greater than, swap, then siftUp again
		if (current.getValue() > parent.getValue()) {
			this.heap.remove(parent);
			this.heap.remove(current);
			this.heap.add(parentIndex, current);
			this.heap.add(index, parent);
			siftUp(parentIndex);
		}
	}

	private void siftDown(int index) {
		// if only node, then it's already at bottom
		if (this.size == 1) {
			return;
		}

		// Set params related to current node
		// left and right child indices
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		// index for swap value if heap property is broken (default current)
		int swapIndex = index;

		// Get current node and set as initial swap value;
		TreeNode current = this.heap.get(index);
		TreeNode swap = current;

		// check if left child is greater than the swap value
		// if so, use as new swap value
		if (leftChildIndex < size - 1) {
			TreeNode leftChild = this.heap.get(leftChildIndex);
			if (swap.getValue() < leftChild.getValue()) {
				swapIndex = leftChildIndex;
				swap = leftChild;
			}
		}

		// check if right child is greater than swap value
		// if so, use as new swap value
		if (rightChildIndex < size - 1) {
			TreeNode rightChild = this.heap.get(rightChildIndex);
			if (swap.getValue() < rightChild.getValue()) {
				swapIndex = rightChildIndex;
				swap = rightChild;
			}
		}

		// swap values with current node and siftDown again
		if (swapIndex != index) {
			this.heap.remove(swap);
			this.heap.remove(current);
			this.heap.add(index, swap);
			this.heap.add(swapIndex, current);
			siftDown(swapIndex);
		}
	}

	public void printTree() {
		for (int i = 0; i < size; i++) {
			TreeNode node = this.heap.remove(0);
			System.out.println(node.getValue());
		}
	}
}
