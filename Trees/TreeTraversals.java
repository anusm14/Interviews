import java.util.*;
/*
userid - anusm14
*/
public class TreeTraversals {

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void inorderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        
        while(true){
            if(node != null){//go to extreme lefrt and keep changing the root
                stack.addFirst(node);
                node = node.left; //change root to its left till null
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst(); //pop the last value and now make root as right
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
    
    public void preOrderItr(Node root){
    	
    	// first print the current node, then the left and right child..
    	//as stack is LIFO, we enter right child first n then left,
    	//so poping left child prints first n then right
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root); //add root
        while(!stack.isEmpty()){
            root = stack.pollFirst(); //print the root first
            System.out.print(root.data + " ");
            if(root.right != null){
                stack.addFirst(root.right); //add the right child first
            }
            if(root.left!= null){
                stack.addFirst(root.left); //then add the lefft child
            }
        }
    }
    
    public void postOrderItr(Node root){
    	
    	//take 2 stacks..add one node at a time.
    	//pop the node and add in stack 2 and add its left and right
    	//again pop the node of stack and add its left and right
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        stack1.addFirst(root);//add in first stack
        while(!stack1.isEmpty()){
            root = stack1.pollFirst(); //pop the value
            if(root.left != null){
                stack1.addFirst(root.left); //add left node
            }
            if(root.right != null){
                stack1.addFirst(root.right); //add right node
            }
            stack2.addFirst(root); //add value in sec stack
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pollFirst().data + " ");
        }
    }
    
    public void postOrderItrOneStack(Node root){
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(19, head);
        head = bt.addNode(17, head);
        head = bt.addNode(11, head);

        head = bt.addNode(-11, head);


        TreeTraversals tt = new TreeTraversals();
        tt.postOrder(head);
        System.out.println();
        tt.postOrderItr(head);
        System.out.println();
        tt.postOrderItrOneStack(head);
    }
}

