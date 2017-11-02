import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	
	public class Node{
		int data;
		Node left;
		Node right;
		
		Node(int value)
		{
			data= value;
			left=null;
			right=null;
		}
		
		
		
	}
	
	/* * Lowest common ancestor in binary search tree.
	 *
	 * Time complexity O(height of tree)
	 * Space complexity O(height of tree)
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 */
	

	    public Node lowestCommonAncestor(Node root, int p, int q) 
	    {
	    	if(root.data > Math.max(p, q))
	    		return lowestCommonAncestor(root.left,p,q);
	    	else if(root.data < Math.min(p, q))
	    		return lowestCommonAncestor(root.right, p, q);
	    	else
	    		return root;
	    }
	    
	    
	//return no of nodes in binary tree
	int sizeofBinaryTree(Node root)
	{
		if(root==null)
			return 0;
		int left = sizeofBinaryTree(root.left);
		int right=sizeofBinaryTree(root.right);
		return left + right+1;
	}
	
	boolean sameTree(Node root1, Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		return (root1.data==root2.data) && sameTree(root1.left,root2.left) 
				&& sameTree(root1.right,root2.right);
	}
	
	static Node GetNewNode(int value)
	{
		return null;
	//	Node bst = new Node();
	//	bst.data=value;	
	//	bst.left= null;
	//	bst.right=null;
	//	return bst;
	}
	
	 Node insert(Node root,int value)
	{
		if(root==null)
		{
			root =  new Node(value);
			return root;
			
		}
		else if(value<=root.data)
			root.left=insert(root.left,value);
		else if(value>root.data)
			root.right=	insert(root.right,value);
		return root;
	}
	
	static boolean search(Node root,int value)
	{
		if(root==null)
			return false;	
		if(root.data==value) return true;
		
			if(value <=root.data)
				return search(root.left,value);
			else return search(root.right,value);
		
		
	}
	
	int findMinIterative(Node root)
	{
		if(root==null)
		{
			System.out.println("Empty tree");
			return -1;
		}
		while(root.left!=null)
			root = root.left;
		return root.data;
	}
	
	int findMaxIterative(Node root)
	{
		if(root==null)
		{
			System.out.println("Empty tree");
			return -1;
		}
		while(root.right!=null)
			root = root.right;
		return root.data;
	}
	
	int findMinRecursive(Node root)
	{
		if(root==null)
		{
			System.out.println("Empty tree");
			return -1;
		}
		else if(root.left==null)
			return root.data;
		return findMinRecursive(root.left);
	}
	
	int findMaxRecursive(Node root)
	{
		if(root==null)
		{
			System.out.println("Empty tree");
			return -1;
		}
		else if(root.right==null)
			return root.data;
		return findMaxRecursive(root.right);
	}
	
	static int findHeight(Node root)
	{
		if (root==null)
			return -1 ; //coz we add 1 each time,
		int left = findHeight(root.left);
		int right=findHeight(root.right);
		return Math.max(left,right )+ 1;
	}
	
	
	void levelOrderTraversal(Node root)
	{
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node current = q.peek();
			System.out.println(current.data);
			if(current.left!=null)
				q.add(current.left);
			if(current.right!=null)
				q.add(current.right);
			q.remove();
		}
		
	}
	
	void levelOrderTraversalWithHeight(Node root)
	{
		int height = findHeight(root);
		for(int i=1;i<=height;i++)
			printGivenLevel(root,i);
	}
	
	void printGivenLevel(Node root,int level)
	{
		if(root==null)
			return;
		if(level==1)
			System.out.println(root.data);
		else if(level>1)
		{
			printGivenLevel(root.left,level-1);
		
			printGivenLevel(root.right, level-1);
			
		}
	}
	
	void preOrderTraversal(Node root)
	{
		if(root==null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	void inOrderTraversal(Node root)
	{
		if(root==null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	void postOrderTraversal(Node root)
	{
		if(root==null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}
	
	
	private boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max); //change min n max value to root value
    }
	
	/*boolean isBSTUtil(Node root,Integer minvalue,Integer maxvalue)
	{
		if (root==null)
			return true;
		if(root.data>minvalue 
			&& root.data < maxvalue
			&& isBSTUtil(root.left, minvalue, root.data)
			&& isBSTUtil(root.right, root.data, maxvalue))
			return true;
		else
			return false;
	}*/
	
	boolean isBinarySearchTree(Node root)
	{
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	 /* Function to calculate the minimum depth of the tree */
    int minimumDepth(Node root)
    {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;
 
	        // Base case : Leaf Node. This accounts for height = 1.
	        if (root.left == null && root.right == null)
	            return 1;
	 
	        // If left subtree is NULL, recur for right subtree
	        if (root.left == null)
	            return minimumDepth(root.right) + 1;
	 
	        // If right subtree is NULL, recur for right subtree
	        if (root.right == null)
	            return minimumDepth(root.left) + 1;
 
        return Math.min(minimumDepth(root.left),
                        minimumDepth(root.right)) + 1;
    }

	public static void main(String args[])
	
	{
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		root = bst.insert(root,3);
		root = bst.insert(root,2);
		root = bst.insert(root,4);
		root = bst.insert(root,1);
		root = bst.insert(root,5);
		
		System.out.println(" number present :" + search(root,5));
		System.out.println(" min recursive : "+ bst.findMinRecursive(root));
		System.out.println(" min iterative :" + bst.findMinIterative(root));
		System.out.println(" max recusrvie : " + bst.findMaxRecursive(root));
		System.out.println(" max iterative :" + bst.findMaxIterative(root));
		System.out.println("Height of tree 	" + findHeight(root));
		//System.out.println("Level order traversal : ");
	//	bst.levelOrderTraversal(root);
		//bst.levelOrderTraversalWithHeight(root);
		//bst.preOrderTraversal(root);
	//bst.inOrderTraversal(root);
		//bst.postOrderTraversal(root);
		System.out.println(bst.isBinarySearchTree(root));
		DeleteNode dnode = new DeleteNode();
		//dnode.Delete(root, 3);
		InOrderSuccesorBST inBst = new InOrderSuccesorBST();
		System.out.println("successor " + inBst.GetSuccesor(root, 1).data);
		bst.inOrderTraversal(root);
		
		
	}
	
}
