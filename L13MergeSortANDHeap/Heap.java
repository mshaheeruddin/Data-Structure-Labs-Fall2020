package L13MergeSortANDHeap;

public class Heap<T> {
    //Method heapify

    private void heapify(T[] list, int low, int high) {
        int largeIndex;
        Comparable<T> temp =
                (Comparable<T>) list[low];  //copy the root node of the subtree
        largeIndex = 2 * low + 1;  //index of the left child
        while (largeIndex <= high) {
            if (largeIndex < high) {
                Comparable<T> compElem =
                        (Comparable<T>) list[largeIndex];
                if (compElem.compareTo(list[largeIndex + 1]) < 0)
                    largeIndex = largeIndex + 1; //index of the largest child
            }

            if (temp.compareTo(list[largeIndex]) > 0) //subtree
                //is already in a heap
                break;
            else {
                list[low] = list[largeIndex]; //move the larger
                //child to the root
                low = largeIndex;    //go to the subtree to
                //restore the heap
                largeIndex = 2 * low + 1;
            }
        }//end while
        list[low] = (T) temp; //insert temp into the tree,
        //that is, list
    }//end heapify


    //Method buildHeap
    private void buildHeap(T[] list, int length) {
        for (int index = length / 2 - 1; index >= 0; index--)
            heapify(list, index, length - 1);
    }//end buildHeap

    //Method heapSort
    public void heapSort(T[] list, int length) {
        buildHeap(list, length);
        for (int lastOutOfOrder = length - 1; lastOutOfOrder >= 0;
             lastOutOfOrder--) {
            T temp = list[lastOutOfOrder];
            list[lastOutOfOrder] = list[0];
            list[0] = temp;
            heapify(list, 0, lastOutOfOrder - 1);
        }//end for
    }
    //end heapSort
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        Heap<Integer> heap = new Heap<>();
        double startTime = System.nanoTime();
        heap.heapSort(arr1,arr1.length);
        double endTime = System.nanoTime();

        double timeElapsed = endTime - startTime;
        System.out.println(timeElapsed);
    }
}