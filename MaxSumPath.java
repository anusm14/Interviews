



/*
 *

 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/#/solutions
 * 
 * For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child

The idea is to keep trace of four paths and pick up the max one in the end.
 An important thing to note is, root of every subtree need to return maximum path sum 
 such that at most one child of root is involved. This is needed for parent function call. 
 In below code, 
this sum is stored in ‘max_single’ and returned by the recursive function.
 */

public class MaxSumPath extends BinarySearchTree {
	
	static int maxValue =0;
	 static Node root;
	
	static int findMaxSumPath(Node root)
	{
		if(root ==null)
			return 0;
		
		// l and r store maximum path sum going through left and
        // right child of root respectively
		int left = Math.max(0, findMaxSumPath(root.left));
		int right = Math.max(0,findMaxSumPath(root.right));
		maxValue = Math.max(left+ right + root.data, maxValue);
		return Math.max(left,right) + root.data;
		
		
	}
	
	static int maxPath(Node root)
	{
		maxValue =0;
		findMaxSumPath(root);
		return maxValue;
	}
	
	public static void main(String args[])
	{
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		root = bst.insert(root,10);
		root = bst.insert(root,2);
		root = bst.insert(root,10);
		root = bst.insert(root,20);
		root = bst.insert(root,1);
		root = bst.insert(root,-25);
		root = bst.insert(root,3);
		root = bst.insert(root,4);
		
		/*BinarySearchTree tree = new BinarySearchTree();
		root = bst.insert(root,10);
        tree.root = root;
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);*/
		
		System.out.println(" max sum path : " + maxPath(root));
		
	}

}
