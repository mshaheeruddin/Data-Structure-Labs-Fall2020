package L10BST;

import java.util.*;
public class BST {

    private BSTNode root;

    /* Constructor */
    public BST() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }
    /* Functions to insert data */

    public void insert(int data) {
        root = insert(root, data);
    }

    /* public void insert(BSTNode r, int data)
     {
         BSTNode n= new BSTNode(data);
         if (r== null)
             root= n;
         else
          {
             BSTNode temp=root;
             if (data< temp.getData() )
                 insert (temp.getLeft(),data);
             else
                 insert (temp.getRight(),data);
          }
      //   root = insert(root, data);
     } */
    /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data) {
        if (node == null)
            node = new BSTNode(data);
        else {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    /* Functions to delete data */
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k)  // if we want to delete root node
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null) // leaf node deletion
                return null;
            else if (lt == null)  //  when one child left does not exist
            {
                p = rt;
                return p;
            } else if (rt == null) // when one child right does not exist

            {
                p = lt;
                return p;
            } else {// two children // pick the right and move to the left most child
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) // either I have to go left
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k); // I have to search at right
            root.setRight(n);
        }
        return root;
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    private boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }


    //Sum of Leaves
    //Q1
    boolean isLeaf(BSTNode r) {
        if (r == null)
            return false;
        if (r.left == null && r.right == null)
            return true;
        return false;
    }
    public int sumOfLeftLeaves() {
        return sumOfLeftLeaves(root);
    }
    private int sumOfLeftLeaves(BSTNode r) {
        int sum = 0;
        if (r != null)
        {
            if (isLeaf(r.left))
                sum += r.left.data;
            else
                sum += sumOfLeftLeaves(r.left);

            sum += sumOfLeftLeaves(r.right);
        }
        return sum;
    }

    //Q2
    //Is tree full?
    public boolean isFull() {
       return isFull(root);
    }
    public boolean isFull(BSTNode r) {
        if (r!=null)
        {
            if(r.getRight() == null && r.getLeft() == null)
            {
                return true;
            }
            if ((r.getRight() != null && r.getLeft() != null))
            {
                return isFull(r.getRight())&&isFull(r.getLeft());
            }
        }
        return false;
    }





	public static void main(String[] args) {
		// 
	       Scanner scan = new Scanner(System.in);
	        /* Creating object of BST */
	        BST bst = new BST();
	         System.out.println("Binary Search Tree Test\n");          
	        char ch;
	        /*  Perform tree operations  */
	        do    
	        {
	            System.out.println("\nBinary Search Tree Operations\n");
	            System.out.println("1. insert ");
	            System.out.println("2. delete");
	            System.out.println("3. search");
	            System.out.println("4. count nodes");
	            System.out.println("5. check empty");
                System.out.println("6. Check if tree is full");
	 
	            int choice = scan.nextInt();
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                bst.insert( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to delete");
	                bst.delete( scan.nextInt() );                     
	                break;                         
	            case 3 : 
	                System.out.println("Enter integer element to search");
	                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
	                break;                                          
	            case 4 : 
	                System.out.println("Nodes = "+ bst.countNodes());
	                break;     
	            case 5 :  
	                System.out.println("Empty status = "+ bst.isEmpty());
	                break;
	                case 6:
                        System.out.println("Tree is full: " + bst.isFull());
                        break;
	            default :
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            /*  Display tree  */ 
	            System.out.print("\nPost order : ");
	            bst.postorder();
	            System.out.print("\nPre order : ");
	            bst.preorder();
	            System.out.print("\nIn order : ");
	            bst.inorder();
                System.out.print("\nSum of Left Leaves: ");
                System.out.println(bst.sumOfLeftLeaves());
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);                        
	        } while (ch == 'Y'|| ch == 'y');               
	 

	}

}
