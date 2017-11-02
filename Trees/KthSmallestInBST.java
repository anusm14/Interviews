

/*
UserID=anusm14
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ? k ? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
 */
public class KthSmallestInBST extends BinarySearchTree{
	
	//A simpler solution would be to do an inorder traversal and keep track of the element currently
	//to be printed with a counter k.
	//When we reach k, print the element. The runtime is O(n). Remember the function return 
	//type can not be void, it has to return its updated value of k after each recursive call. 
	//		A better solution to this would be an augmented BST with a sorted position value at 
	//		each node.

			public static int kthSmallestInOrder (Node pivot, int k){
			    if(pivot == null )
			        return k;   
			    k = kthSmallestInOrder(pivot.left, k);
			    k--;
			    if(k == 0){
			        System.out.println(pivot.data);
			    }
			    k = kthSmallestInOrder(pivot.right, k);
			    return k;
			}
	
	
	static int kthSmallest(Node root,int k)
	{
		if(root==null)
			return 0;
		
			 int count = countNodes(root.left) ; //left as we need smallest element;
			 
			 if(k<=count)
				 return kthSmallest(root.left, k);
			 else if(k> count +1)
				 return kthSmallest(root.right, k-1-count);
		
		
		return root.data;
		
	}
	
	static int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return 1+ countNodes(root.left) + countNodes(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		/*root = bst.insert(root,3);
		root = bst.insert(root,2);
		root = bst.insert(root,4);
		root = bst.insert(root,1);
		root = bst.insert(root,5);*/
        		
		root = bst.insert(root,2);
		root = bst.insert(root,1);
       kthSmallestInOrder(root,1);
       // System.out.println("kth smallest " + value);
	}

}
