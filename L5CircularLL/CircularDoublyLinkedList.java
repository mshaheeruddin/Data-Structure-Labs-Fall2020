package L5CircularLL;

public class CircularDoublyLinkedList {
	private Node head;
    private int size;

    public CircularDoublyLinkedList() {
	  head= null;
	  size=0;
	}
	private class Node {
		 
		Object data;
		Node next;
		Node prev;
		
		public Node(Object data, Node prev, Node next ) {
			this.data=data;
			this.next= next;
			this.prev= prev;
		 }
		}
	
	public void insertAtLast(Object data) {
		if (head == null)
		{
			Node fNode = new Node(data,null,null);
			fNode.next = fNode.prev;
			fNode.prev	= fNode;
			head = fNode;
		}

		else if (head != null ) {

			Node lastNode = head.prev;

			Node tmp = new Node(data, lastNode, head);

			head.prev = tmp;

			lastNode.next = tmp;
		}
	}


	public void removeAtLast() {
    	Node lastNode = head.prev;
        if (head.prev != null) {
        	head.prev = lastNode.prev;
        	lastNode.prev.next = lastNode.next;
        	lastNode.prev =null;
        	System.gc();
		}

	}
	 public Node getNode(int index) {
    	 Node tmp =head;
		 for (int i = 0;i<index;i++) {
		 	tmp = tmp.next;
		 }
			 System.out.println(tmp.data);
          return tmp;
	 }
	 public void iterateForward( ) {
		 Node tmp = head;
		 System.out.println("Iterating Forward....");
		 while (tmp.next != head)
		 {
			 System.out.print(tmp.data);
			 System.out.print(",");
			 tmp = tmp.next;
		 }
		 System.out.println(tmp.data);

	 }
	 public void iterateBackward( ) {
		 Node tmp = head;
		 System.out.println("Iterating Backward....");
		 Node last = head.prev;
		 tmp = last;
		 while (tmp.prev != last)
		 {
			 System.out.print(tmp.data + ",");
			 tmp = tmp.prev;
		 }
		 System.out.println(tmp.data);

	}

// The method check circular traverses the list and checks if the list is circular. It return true if the list
//	is circular and returns false if list is not circular. 

	 boolean Check_Circular(){
    	Node lastNode = head.prev;
    	if (lastNode.next == head && head.prev == lastNode) {
			System.out.println(true);
    		return true;
		}
    	System.out.println(false);
    	return false;
		 }

		}
