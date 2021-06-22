package L11SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void Quicksort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            Quicksort(arr, low, pi-1);
            Quicksort(arr, pi+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,4,1,5,2};
        QuickSort quickSort = new QuickSort();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        //array creation
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 10000) + 1;
        }
        quickSort.Quicksort(array,0,arr.length-1);
        double startTime = System.nanoTime();
        quickSort.Quicksort(array,0,arr.length-1);
        double endTime = System.nanoTime();
        double timeElapsed = endTime - startTime;
        System.out.println(timeElapsed);


    }

}
