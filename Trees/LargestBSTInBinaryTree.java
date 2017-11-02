	/**
 * 
 * 
 * Video link - https://youtu.be/4fiDs7CCxkc
 * 
 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 * 
 * References:
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBSTInBinaryTree {
	
	int largestBST(Node root)
	{
		MinMax MaxBST = largest(root);
		return MaxBST.size;
	}
	
	MinMax largest(Node root)
	{
		 //if root is null return min as Integer.MAX and max as Integer.MIN 
		if(root==null)
			return new MinMax();
		
		 //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
		
		MinMax leftTree = largest(root.left);
		MinMax rightTree = largest(root.right);
		
		MinMax current = new MinMax();
		//if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
		if(leftTree.isBST==false || rightTree.isBST==false ||
				(leftTree.min < root.data || rightTree.max >root.data))
		{
			current.isBST=false;
			current.size=Math.max(leftTree.max, rightTree.max);
			return current;
		}
		
		//if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
		
		current.isBST=true;
		current.size=leftTree.size + rightTree.size;
		
		//if root.left is null then set root.data as min else
        //take min of left side as min
		current.min = root.left != null ? leftTree.min : root.data;
		
		//if root.right is null then set root.data as max else
        //take max of right side as max.
		current.max=root.right !=null ? rightTree.max : root.data;
		
		return current;
		
		
	}
	
	public static void main(String args[])
	{
	
	LargestBSTInBinaryTree lbi = new LargestBSTInBinaryTree();
 /*   ConstructTreeFromInOrderPreOrder ctf = new ConstructTreeFromInOrderPreOrder();
    //this is just to create a binary tree.
    int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
    int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
    Node root = ctf.createTree(inorder, preorder);*/
	Node root = new Node();
    int largestBSTSize = lbi.largestBST(root); 
    System.out.println("Size of largest BST  is " + largestBSTSize);
	}
   

	
	class MinMax {
		int min;
		int max;
		boolean isBST;
		int size;
		
		MinMax(){
	        min = Integer.MAX_VALUE;
	        max = Integer.MIN_VALUE;
	        isBST = true;
	        size = 0;
	    }
	}

}
