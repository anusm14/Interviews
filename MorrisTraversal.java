/*
 * Morris inorder/preorder traversals
 * 
 * https://www.youtube.com/watch?v=wGXB9OWhPTg&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=20
 * 
 * 1. Initialize current as root 
 2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left
 *
 * Time complexity O(n)
 * Space complexity O(1)
 * 
 * Limitations:
Morris traversal modifies the tree during the process. 
It establishes the right links while moving down the tree and resets the right links while
 moving up the tree. 
So the algorithm cannot be applied if write operations are not allowed.
 */
public class MorrisTraversal {
	
	void inorder(Node root)
	{
		Node current=root;
		
		while(current!=null)
		{
			//left is null then print the node and go to right 
			//means we are done traversing left
			if(current.left==null)
			{
				System.out.print(current.data +  " ");
				current=current.right;
			}
			else{
			Node predecessor = current.left;
			//To find predecessor keep going right till right node is not null 
			//or right node is not current.
			while(predecessor.right != current && predecessor.right!=null)
			{
				predecessor= predecessor.right;
			}
			
			//if right node is null then go left after establishing link from predecessor to current.
			if(predecessor.right==null)
			{
				//we reached end so now create link to current
				predecessor.right=current;
				current=current.left;
			}
			else{//left is already visit. Go rigth after visiting current.
				predecessor.right=null;//delete the link created
				System.out.print(current.data + " ");
				current = current.right;
				
			}
			}
				
		}
	}
	
	public void preorder(Node root) {
        Node current = root;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.data + " ");//print data here
                    current = current.left;
                }else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
	
	  public static void main(String args[]) {
	        BinaryTree bt = new BinaryTree();
	        Node root = null;
	        root = bt.addNode(10, root);
	        root = bt.addNode(50, root);
	        root = bt.addNode(-10, root);
	        root = bt.addNode(7, root);
	        root = bt.addNode(9, root);
	        root = bt.addNode(-20, root);
	        root = bt.addNode(30, root);
	        MorrisTraversal mt = new MorrisTraversal();
	        mt.inorder(root);
	        System.out.println();
	        mt.preorder(root);
	    }

}
