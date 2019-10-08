import java.lang.*;
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
		if (key <1 || key > 99) {
			throw new IllegalArgumentException("The number is not between 1 and 99");
		}
		else {
			boolean status = false;
			if (leaf == null) {
				leaf = new TreeNode(key);
				return true;
			}
			TreeNode current = leaf;
			TreeNode parent = null;
			while(current != null) {
				parent = current;
				if (key > current.key && current.deleted == false) {
					current = current.rightChild;
				}
				else if (key < current.key && current.deleted == false) {
					current = current.leftChild;
				}
				else if (key == current.key && current.deleted == true) {
					//Undelete
					return true;
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
	}
	//need to test
	public boolean delete(int key) {
		boolean status = false;
		if (key <1 || key > 99) {
			throw new IllegalArgumentException("The number is not between 1 and 99");
		}
		else {
			if (leaf == null) {
				return false;
			}
			TreeNode current = leaf;
			while (current != null) {
				if (current.key == key) {
					current.deleted = true; //Not saving the value
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
	}
	
	public int findMin() {
		int min = -1;
		if (leaf == null) {
			return min;
		}
		else {
			TreeNode current = leaf;
			while (current != null) {
				if(current.leftChild == null && current.deleted == false) {
					return min = current.key;
				}
				else {
					current = current.leftChild;
				}
			}
		}
		return min;
	}
	
	public int findMax() {
		int max = -1;
		if (leaf == null) {
			return max;
		}
		else {
			TreeNode current = leaf;
			while (current != null) {
				if(current.rightChild == null && current.deleted) {
					return max = current.key;
				}
				else {
					current = current.rightChild;
				}
			}
		}
		return max;
	}
	
	//need to test
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
		return traverseTree(leaf);
	}
	
	//Healper method for toString, uses recursion
	public String traverseTree(TreeNode root) {
		if (root == null) {
			return "";
		}
		else {
			if (root.deleted == true) {
				return ("*" + root.key + " ") +
						traverseTree(root.leftChild) + 
						traverseTree(root.rightChild);
			}
			else {
				return (root.key +" ") +
						traverseTree(root.leftChild) +
						traverseTree(root.rightChild);
			}
		}
	}
	
	public int height() {
		return maxHeight(leaf);
	}
	
	//Helper method for height
	public int maxHeight (TreeNode root) {
		if (root == null) {
			return 0;
		}
		else {
			int leftHeight = maxHeight(root.leftChild);
			int rightHeight = maxHeight(root.rightChild);
			
			if(leftHeight > rightHeight) {
				return (leftHeight + 1);
			}
			else {
				return (rightHeight + 1);
			}
		}
	}
	
	public int size() {
		return sizeCount(leaf);
	}
	
	public int sizeCount(TreeNode root) {
		if (root == null) {
			return 0;
		}
		else {
			return 1 + sizeCount(root.leftChild) + 
					sizeCount(root.rightChild); 
		}
	}
	
}
