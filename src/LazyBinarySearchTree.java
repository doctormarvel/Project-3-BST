
public class LazyBinarySearchTree {
	private class TreeNode {
		int key;
		TreeNode leftChild;
		TreeNode rightChild;
		boolean deleted;
		
		public TreeNode (int value) {
			key = value;
			leftChild = null;
			rightChild = null;
			deleted = false;
		}
	}
	TreeNode leaf;
	
	public LazyBinarySearchTree() {
		leaf = null;
	}
	
	public boolean insert(int key){
		boolean status = false;
		if (leaf == null) {
			leaf = new TreeNode(key);
			return true;
		}
		TreeNode current = leaf;
		TreeNode parent = null;
		while(current != null) {
			parent = current;
			if (key > current.key) {
				current = current.rightChild;
			}
			else if (key < current.key) {
				current = current.leftChild;
			}
			else {
				return false;
			}
		}
		
		TreeNode newLeaf = new TreeNode(key);
		if(parent.key > key){
			parent.leftChild = newLeaf;
			status = true;
		}
		else {
			parent.rightChild = newLeaf;
			status = true;
		}
		
		return status;
	}
	
	public boolean delete(int key) {
		boolean status = false;
		if (leaf == null) {
			return false;
		}
		TreeNode current = leaf;
		while (current != null) {
			if (current.key == key) {
				current.deleted = true;
				status = true;
				break;
			}
			else {
				
			}
		}
		return status; 
	}
	
	public int findMin() {
		return -1; //temp return value
	}
	
	public int findMax() {
		return -1; //temp return value
	}
	
	public boolean contains(int key) {
		boolean status = false;
		if(leaf == null) {
			return false;
		}
		TreeNode current = leaf;
		while (current != null) {
			if (current.key == key && current.deleted == false) {
				status = true;
				break;
			}
			else {
				if (key > current.key) {
					current = current.rightChild;
				}
				else if (key < current.key) {
					current = current.leftChild;
				}
				else {
					return false;
				}
			}
		}
		return status;
	}
	
	public String toString() {
		return null; //temp return value
	}
	
	public int height() {
		return 0; //temp return value
	}
	
	public int size() {
		int count = 0;
		return count;
	}
	
}
