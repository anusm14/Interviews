/*
 * AVL tree is a self-balancing Binary Search Tree (BST) where the 
 * difference between heights of left and right subtrees cannot be more than one for all nodes.

* Complexity of AVL tree is O(logN)
* 
* 
*Why we need AVL Tree - cost of operation on BST is usually o(h) and in worst case ie we have full left
*tree or full right tree the complexity becomes o(n) .Hence in order to always have a complexity
*of o(logN) we can construct a AVL tree instead of binary search tree
*
*Steps to follow for insertion
Let the newly inserted node be w
1) Perform standard BST insert for w.
2) Starting from w, travel up and find the first unbalanced node. Let z be the first unbalanced node, y be the child of z that comes on the path from w to z and x be the grandchild of z that comes on the path from w to z.
3) Re-balance the tree by performing appropriate rotations on the subtree rooted with z. There can be 4 possible cases that needs to be handled as x, y and z can be arranged in 4 ways. Following are the possible 4 arrangements:
a) y is left child of z and x is left child of y (Left Left Case)
b) y is left child of z and x is right child of y (Left Right Case)
c) y is right child of z and x is right child of y (Right Right Case)
d) y is right child of z and x is left child of y (Right Left Case)

a) Left Left Case

T1, T2, T3 and T4 are subtrees.
         z                                      y 
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \ 
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2
  
  b) Left Right Case

     z                               z                           x
    / \                            /   \                        /  \ 
   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
T1   x                          y    T3                    T1  T2 T3  T4
    / \                        / \
  T2   T3                    T1   T2
  
c) Right Right Case

  z                                y
 /  \                            /   \ 
T1   y     Left Rotate(z)       z      x
    /  \   - - - - - - - ->    / \    / \
   T2   x                     T1  T2 T3  T4
       / \
     T3  T4
     
d) Right Left Case

   z                            z                            x
  / \                          / \                          /  \ 
T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
   x   T4                      T2   y                  T1  T2  T3  T4
  / \                              /  \
T2   T3                           T3   T4


http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
 */
public class AVLTree {
	
	private Node leftRotate(Node root)
	{
		Node newRoot = root.right;
		root.right=newRoot.left;
		newRoot.left=root;
		
		root.height=setHeight(root);
		root.size=setSize(root);
		
		newRoot.height=setHeight(newRoot);
		newRoot.size=setSize(newRoot);
		
		return newRoot;
	}
	
	private Node rightRotate(Node root)
	{
		Node newRoot=root.left;
		root.left=newRoot.right;
		newRoot.right=root;
		
		root.height=setHeight(root);
		root.size=setSize(root);
		
		newRoot.height=setHeight(newRoot);
		newRoot.size=setSize(newRoot);
		
		return newRoot;
	}
	
	int setSize(Node root)
	{
		return 1+Math.max((root.left!=null ? root.left.size:0),(root.right!=null?root.right.size:0));
	}
	
	int setHeight(Node root)
	{
		return 1+Math.max((root.left!=null ? root.left.height:0),(root.right!=null?root.right.height:0));
	}
	
	private int height(Node root)
	{
		if(root==null)
			return 0;
		else
			return root.height;
	}
	
	int balance(Node left, Node right)
	{
		return height(left)-height(right);
	}
	
	
	
Node insert(Node root, int data)
	{
		if(root == null){
            return Node.newNode(data);
        }
		
		 if(root.data <= data){
	            root.right = insert(root.right,data);
	        }
	        else{
	            root.left = insert(root.left,data);
	        }
		
		int balance = balance(root.left,root.right);
		
		if(balance > 1) 
		{
			if(height(root.left.left) >= height(root.left.right))
					root = rightRotate(root);
			else
			{
				root.left = leftRotate(root.left);
				root= rightRotate(root);
			}
			
		}
		else if(balance < -1)
		{
			if(height(root.right.left) <= height(root.right.right))
					root= leftRotate(root);
			else{
				root.right=rightRotate(root.right);
				root=leftRotate(root);
			}
		}
		else {
			root.height=setHeight(root);
			root.size=setSize(root);
		}
		return root;
	}
	
	public static void main(String args[]){

	
	 AVLTree avlTree = new AVLTree();
     Node root = null;
    /* root = avlTree.insert(root, -10);
     root = avlTree.insert(root, 2);
     root = avlTree.insert(root, 13);
     root = avlTree.insert(root, -13);
     root = avlTree.insert(root, -15);
     root = avlTree.insert(root, 15);
     root = avlTree.insert(root, 17);
     root = avlTree.insert(root, 20);*/
     
     
     root = avlTree.insert(root, 10);
     root = avlTree.insert(root, 20);
     root = avlTree.insert(root, 30);
     root = avlTree.insert(root, 40);
     root = avlTree.insert(root, 50);
     root = avlTree.insert(root, 25);
    
     
     TreeTraversals tt = new TreeTraversals();
     tt.inOrder(root);
     System.out.println();
     tt.preOrder(root);
     
	}
}
