import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalLevelByLevel {
	
	static void levelByLevelTwoQueue(Node root)
	{
		if(root==null)
			return;
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(root);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				root=q1.poll();
				System.out.print(root.data + " "); //dont use print ln
				if(root.left!=null)
					
					q2.add(root.left);
				if(root.right!=null)
					q2.add(root.right);
			}
			System.out.println( );//go next line when changing queues

			while(!q2.isEmpty())
			{
				root=q2.poll();
				System.out.print(root.data + " ");
				if(root.left!=null)
					q1.add(root.left);
				if(root.right!=null)
					q1.add(root.right);
			}
			System.out.println( );//go next line when changing queues
		}
		
	}
	

	public void levelByLevelOneQueueUsingDelimiter(Node root)
	{
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty())
        {
        	root=q.poll();
        	if(root!=null)
        	{
        		System.out.print(root.data + " ");
        		if(root.left!=null)
        			q.add(root.left);
        		if(root.right!=null)
        			q.add(root.right);
        		
        	}
        	else
        	{
        		if(!q.isEmpty())
        		{
        			System.out.println();
        			q.add(null);
        		}
        	}
        }
	}
	
	/**
     * Use one queue and count to print level by level
     */
    public void levelByLevelOneQueueUsingCount(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        int levelCount = 1;
        int currentCount = 0;
        q.add(root);
        while (!q.isEmpty()) {
            while (levelCount > 0) {
                root = q.poll();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    currentCount++;
                    q.add(root.left);
                }
                if (root.right != null) {
                    currentCount++;
                    q.add(root.right);
                }
                levelCount--;
            }
            System.out.println();
            levelCount = currentCount;
            currentCount = 0;
        }
    }
	
	
	 public static void main(String args[]) {
	        TreeTraversalLevelByLevel tt = new TreeTraversalLevelByLevel();
	        BinaryTree bt = new BinaryTree();
	        Node root = null;
	        root = bt.addNode(10, root);
	        root = bt.addNode(20, root);
	        root = bt.addNode(30, root);
	        root = bt.addNode(15, root);
	        root = bt.addNode(-10, root);
	        root = bt.addNode(0, root);
	        root = bt.addNode(5, root);
	        root = bt.addNode(-5, root);
	        root = bt.addNode(-15, root);
	        root = bt.addNode(27, root);
	        root = bt.addNode(35, root);
	        System.out.println("1. Two queue technique");
	        tt.levelByLevelTwoQueue(root);
	        System.out.println("\n2. One queue and delimiter");
	        tt.levelByLevelOneQueueUsingDelimiter(root);
	        System.out.println("\n\n3. One queue and count");
	        tt.levelByLevelOneQueueUsingCount(root);
	    }
}
