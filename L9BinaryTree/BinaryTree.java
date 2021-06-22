package L9BinaryTree;

import L10BST.BST;
import L10BST.BSTNode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public class Node {
        int key; //key of the node
        Node left; //reference for the left child node
        Node right; //reference for the right child node

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    int size = 0;

    public BinaryTree() {
        root = null;
        size = 0;
    }


    public void insertAtLeft(int key) {
        Node n = new Node(key);
        Node temp = root;
        if (temp == null) {
            root = n;
        } else {
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = n;
        }
        size++;
    }

    public void insertAtRight(int key) {
        Node n = new Node(key);
        Node temp = root;
        if (temp == null) {
            root = n;
        } else {
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = n;
        }
        size++;
    }


    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public void inOrderTrav(Node root) {
        if (root != null)
        {
            inOrderTrav(root.left);
            System.out.print(root.key + " ");
            inOrderTrav(root.right);
        }

    }


    public void preOrderTrav(Node root) {
        if (root != null)
        {
            System.out.print(root.key + " ");
            preOrderTrav(root.left);
            preOrderTrav(root.right);
        }
    }

    public void postOrderTrav(Node root) {
        if (root != null)
        {
            postOrderTrav(root.left);
            postOrderTrav(root.right);
            System.out.print(root.key + " ");
        }
    }

    public int height(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }


        public static void main(String[] args) {
            // TODO code application logic here
            BinaryTree bt = new BinaryTree();
            bt.insertAtLeft(12);
            bt.insertAtLeft(4);
            bt.insertAtLeft(5);
            bt.insertAtRight(7);
            bt.insertAtRight(9);
            bt.preOrderTrav(bt.root);

        }

    }

