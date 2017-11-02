import java.lang.*;
import java.util.*;


public class DeleteNode extends BinarySearchTree {
	
	
	Node Delete(Node root,int data)
	{
		if(root==null)
			return root; //tree is empty
		else if(root.data >data) //search in left subtree
			root.left = Delete(root.left,data);//return the new node pointer after node deletion
		else if(root.data<data) //search right subtree
			root.right= Delete(root.right,data);
		
		//Case 1 No child
		else
		{ if(root.left==null && root.right==null)
			//cut link from parent and remove ndoe from memory
			root= null;
			//case 2 only 1 child
			else if(root.left==null)//has only right child
			{
				//Node temp = root;
				root = root.right;
			
			}
			else if(root.right==null)//has only left child
			{
				root=root.left;
			}
			//case 3 both child are not null
			else if(root.left!=null && root.right!=null)
			{
				int temp = findMinRecursive(root.right);//find min in right subtree
				root.data = temp;//copy the value in targetted node 
				root.right = Delete(root.right,root.data);//and delete the node
			}
		}
		 return root;
	}

}
