package L4DoublyLL;

public class DriverDoubly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkTest<Integer> dList= new DoublyLinkTest<Integer>();
        dList.addFirst(6);
        dList.addFirst(7);
        dList.addFirst(9);
        dList.addFirst(10);
        dList.addFirst(77);

       /*
        dList.removeFirst();
        dList.removeLast();
        dList.iterateBackward();
        */
        /* dList.remove(dList.tail);
        dList.iterateForward();
        */
        // dList.AddAfter(dList.head.next,9);

        dList.AddAfter(dList.getNode(3),90);
        //Displays the nodes present in the list    
        dList.iterateForward();

	}

}
