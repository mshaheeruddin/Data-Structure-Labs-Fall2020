package L7ArrayQueue;

class Queue {
    int maxQueueSize;
    int queueFront;
    int queueRear;
    int count;
    Object[] list;

    public Queue() {
        maxQueueSize = 100;
        queueFront = 0;
        queueRear = maxQueueSize - 1; //initialize queueRear
        // count = 0;
        list = new Object[maxQueueSize];
    }

    public Queue(int size) {
        maxQueueSize = size;
        queueFront = 0;
        queueRear = maxQueueSize - 1; //initialize queueRear
        // count = 0;
        list = new Object[maxQueueSize];
    }

    public void initializeQueue() {
        for (int i = queueFront; i < queueRear; i = (i + 1) % maxQueueSize)
            //0 indicates null array
            list[i] = null;
        queueFront = 0;
        queueRear = maxQueueSize - 1;
        count = 0;
    }

    boolean checkNull() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) return true;
        }
        return false;
    }

    void enQueue(Object j) {
        //circular
        if (checkNull()) {
            if (isFullQueue() && list[0] == null) {
                list[(queueRear + 1) % maxQueueSize] = j;
                queueFront = 0;
            } else if (isFullQueue() && list[queueFront + 1] == null) {
                list[(queueRear + 1) % maxQueueSize] = j;
                queueFront = 0;
            }

            if (isEmptyQueue()) {
                list[0] = j;
                count++;
                queueFront = 0;
                queueRear = 0;
            } else {
                try {
                    list[(queueRear + 1) % maxQueueSize] = j;
                    count++;
                } catch (Exception e) {
                }
                queueRear++;
            }
        } else
            System.out.println("Array is full! Can't Add more");

    }

    Object deQueue() {
        if (isEmptyQueue()) return -1;
        Object returnValue = list[queueFront];
        list[queueFront] = null;
        queueFront++;
        return returnValue;
    }

    public boolean isEmptyQueue() {
        return (count == 0);
    }

    public boolean isFullQueue() {
        return (count == maxQueueSize);
    }

    Object peekFront() {
        System.out.println("Front of Queue is: " + list[queueFront]);
        return list[queueFront];
    }

    void display() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != list[list.length - 1])
                System.out.print(list[i] + ",");
            else
                System.out.print(list[i]);
        }
        System.out.println();
    }
    //Question No 3

    void putFront(Object element) {
        if (isFullQueue()) System.out.println("Array is Full, can't add");
        else {
            Object[] tmp = new Object[list.length];

            for (int i = 0; i < list.length - 1; i++) {
                tmp[i] = list[i];
            }
            for (int i = 0; i < list.length - 1; i++) {
                list[i + 1] = tmp[i];
            }

            list[0] = null;
            list[0] = element;
            queueRear++;
            System.out.println();

        }
    }
    Object getRear() {
        Object tmp = new Object();
        if (isEmptyQueue()) System.out.println("Empty List!");
        else {
            tmp = list[queueRear];
            list[queueRear] = null;
            System.out.println("Rear: " + tmp + " is Deleted!");
            count--;
            queueRear--;
        }
        return tmp;
    }
}


    public class ArrayQueue {
        public static void main(String[] args) {
            Queue q = new Queue(5);
            q.enQueue(5);
            q.enQueue(6);
            q.enQueue(7);
            q.enQueue(8);


        q.deQueue();


        }
    }
