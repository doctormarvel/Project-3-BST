import java.lang.*;
public class LazyBinarySearchTree {
	private class TreeNode {
		int key;
		TreeNode leftChild;
		TreeNode rightChild;
		boolean deleted;
		
		//Constructor for TreeNode
		public TreeNode (int value) {
			key = value;
			leftChild = null;
			rightChild = null;
			deleted = false;
		}
	}
	//object for TreeNode
	TreeNode leaf;
	
	//Constructor for LBST
	public LazyBinarySearchTree() {
		leaf = null;
	}
	
	//Insert method, will only take values 1-99
	public boolean insert(int key){
		//Throws exception
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
			TreeNode parent = null; //Needed to know value after while statement
			//Runs through all nodes
			while(current != null) {
				parent = current;
				if (key > current.key) {
					current = current.rightChild;
				}
				else if (key < current.key) {
					current = current.leftChild;
				}
				else if (key == current.key && current.deleted == true) {
					current.deleted = false;
					return true;
				}
				//if the value is equal to the current node, this will pass a false
				else {
					return false;
				}
			}
			//Adding a new node to the LBST
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
	
	//deletes the node specified by the key, 1-99 accepted
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
				if (current.key == key && current.deleted == false) {
					current.deleted = true;
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
	
	//Find the min of the LBST
	public int findMin() {
		int min = -1;
		if (leaf == null) {
			return min;
		}
		else {
			TreeNode current = leaf;
			while (current != null) {
				//only change if deleted equals false
				if(current.deleted == false) {
					min = current.key;
					current = current.leftChild;
				}
				else {
					current = current.leftChild;
				}
			}
		}
		return min;
	}
	
	//finds the max from the LBST
	public int findMax() {
		int max = -1;
		if (leaf == null) {
			return max;
		}
		else {
			TreeNode current = leaf;
			while (current != null) {
				if(current.deleted == false) {
					//Only changes if deleted equals false
					max = current.key;
					current = current.rightChild;
				}
				else {
					current = current.rightChild;
				}
			}
		}
		return max;
	}
	
	//this method checks if a method exist and if it has not been deleted
	public boolean contains(int key) {
		boolean status = false;
		if (key < 1 && key > 99) {
			throw new IllegalArgumentException("The number is not between 1 and 99");
		}
		else {
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
	}
	
	
	public String toString() {
		return traverseTree(leaf);
	}
	
	//Helper method for toString, uses recursion
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
	
	//returns the heights of the LBST, whatever the highest node is returned.
	public int height() {
		return maxHeight(leaf);
	}
	
	//Helper method for height
	public int maxHeight (TreeNode root) {
		if (root == null) {
			return -1;
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
	
	//returns the size of the LBST, how many nodes exist
	public int size() {
		return sizeCount(leaf);
	}
	
	//helper method for size
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
