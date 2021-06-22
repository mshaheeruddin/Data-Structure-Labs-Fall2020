package L7LLQueue;

class Node  {
         Object data;
         Node next;
        Node(){
            data = null;
            next = null;
        }
        Node(Object data){
            this.data = data;
            next = null;
        }
        public Node head = null;
        public Node tail = null;
}
        class Queue {
            Node queueFront;
            Node queueRear;
            int count;

        Queue(){ //constructor
            queueFront = null;
            queueRear = null;
            count = 0;
        }
        public void enQueue(Object value){
            Node nNode = new Node(value);
            if (queueFront == null) {
                queueFront = nNode;
                queueRear = nNode;
                count++;
            }
            else  {
                queueRear.next = nNode;
                queueRear = nNode;
                count++;
            }
        }
        public Object deQueue(){
            Node tmp = queueFront.next;
            Object returnObject = queueFront;
            queueFront = tmp;
            System.gc();

            return returnObject;
        }
        public Object seekFront(){
            System.out.println("Front element is: " + queueFront.data);
            return queueFront;
        }
        public boolean isEmpty(){
            if (queueFront == null && queueRear == null) return true;
            else return false;
        }
        public void Display(){ //prints the queue
           Node tmp = new Node();
           tmp = queueFront;
           while (tmp != null) {
               System.out.print(tmp.data + " ");
               tmp = tmp.next;

            }
            System.out.println();
           }
        }
        public class LinkedListQueue{
    public static void main(String args[]){
        Queue q = new Queue();
        q.enQueue(6);
        q.enQueue(3);
        q.enQueue(2);
        q.deQueue();
        q.enQueue(5);
        q.Display();
        q.seekFront();
    }
}
