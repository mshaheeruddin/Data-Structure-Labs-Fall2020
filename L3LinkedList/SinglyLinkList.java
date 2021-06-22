package L3LinkedList;

public class SinglyLinkList {
   //Represent a node of the singly linked list    
    class Node{    
        int data;    
        Node next;    

        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    //Represent the head and tail of the singly linked list    
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    
    public void addNode(int data) {    
        //Create a new node    
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
        
    //display() will display all the nodes present in the list    
    
    public void display() {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.println(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }    
  
  //addAtStart() will add a new node to the beginning of the list  
    public void addAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
  //addAtEnd() will add a new node to the end of the list  
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        newNode.next = tail.next;
        tail.next = newNode;
    }
   
  //countNodes() will count the nodes present in the list    
    public int countNodes() {  
           int count = 0;
           Node current;
           current = head;
           while (current != null) {
               current = current.next;
               count++;
           }

        return count;
    }
  
    //searchNode() will search for a given node in the list  
    public void searchNode(int data) {
        boolean flag = true;
        int position = 0;
        Node current;
        current = head;
        while (current != null &&  flag) {
            current = current.next;
            position++;
            if(current != null) {
                if (current.data == data) {
                    flag = false;
                    System.out.println("Inquired Node is at position number: " + position);
                    System.out.println("Inquired Node is: " + current.data);
                    break;
                }
            }

        }
          if (flag) {
              System.out.println("Node Not Found!");
          }

    }
    
  //deleteFromStart() will delete a node from the beginning of the list  
    public void deleteFromStart() {
        head = head.next;
        System.gc();
    }
  
    //deleteFromEnd() will delete a node from end of the list  
    public void deleteFromEnd() {
        tail.next = tail.next.next;
        System.gc();
    }
    //Task 2
    SinglyLinkList joinLists(SinglyLinkList p, SinglyLinkList q) {

        SinglyLinkList J = new SinglyLinkList();
        Node jNode = new Node(1);
        
        J.head = jNode;
        J.tail = jNode;



        J.head.next = p.head;
        head = J.head;
        p.tail.next = q.head;

        J.deleteFromStart();


        return J;

    }




}// end of class
