import java.lang.*;
/*
 * Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
	        set the successor as root
	        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
 */
public class InOrderSuccesorBST extends BinarySearchTree{
	
	
	Node GetSuccesor(Node root,int data)
	{
		Node current = Find(root,data); //search the node
		if(current==null)
			return null;//empty tree
		
		if(current.right!=null)
		{
			return findMin(current.right);//go to deepest leftmost node of right subgtree
		}
		
		//If key is smaller then root node
		// set the successor as root
       // search recursively into left subtree
		else if(current.right==null)
		{
			Node ancestor=root;
			Node successor =null;
			
			while(ancestor !=current) //travel till the current node from root
			{
				if(ancestor.data>current.data)
				{
					successor=ancestor;//so far this is the deepest node for whcih current is left
					ancestor=ancestor.left;
				}
				else
					ancestor=ancestor.right;
			}
			return successor;	
		}
		return root;
	}
	
	Node Find(Node root,int value)
	{
		
			if(root==null)
				return null;	
			if(root.data==value) return root;
			
				if(value <=root.data)
					return Find(root.left,value);
				else return Find(root.right,value);
			
			
		}
	
	Node findMin(Node root)
	{
		if(root==null)
		{
			System.out.println("Empty tree");
			return null;
		}
		else if(root.left==null)
			return root;
		return findMin(root.left);
	}

}
