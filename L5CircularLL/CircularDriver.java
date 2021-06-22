package L5CircularLL;

public class CircularDriver {
    public static void main(String[] args) {
         CircularDoublyLinkedList cLL = new CircularDoublyLinkedList();

         cLL.insertAtLast(4);
         cLL.insertAtLast(6);
         cLL.insertAtLast(8);
         cLL.insertAtLast(78);
         cLL.getNode(3);
         cLL.Check_Circular();
         cLL.iterateForward();



    }
}
