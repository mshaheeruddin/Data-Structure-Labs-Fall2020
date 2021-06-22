package L2TimingTest;

import  java.util.Scanner;

public class TimingTest {

    public static int binarySearch(int[] a, int target) {
        int min = 0;
        int max = a.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (a[mid] < target) {
                min = mid + 1;
            } else if (a[mid] > target) {
                max = mid - 1;
            } else {
                return mid; // target found
            }
        }
        return -(min + 1); // target not found
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] removeDuplicateElements(int arr[], int n) {

        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
    public static int[] sortArray(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.println("Enter Size of an Array: ");
        for (int j = 128; j < 6000; j = j * 2) {
            int N = j;
            //array creation
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = (int) (Math.random() * 10000) + 1;
            }
            int[] arrayNew = removeDuplicateElements(array, N);


            int target = (int) (Math.random() * 10000) + 1;

            System.out.println("When N =" + N);


            double initialTime = System.nanoTime();
            linearSearch(arrayNew, target);
            double finishTime = System.nanoTime();

            double timeForLinearSearch = finishTime - initialTime;

            System.out.println("Time Elapsed for Linear Search: " + timeForLinearSearch);

             int[] arr = {1,2,3,4,5,6};
            int[] binaryArray = sortArray(arrayNew);

            double startTime = System.nanoTime();
            binarySearch(arr, 6);
            double endTime = System.nanoTime();

            double timeForBinarySearch = endTime - startTime;
            System.out.println("Time Elapsed for Binary Search: " + timeForBinarySearch);
            System.out.println();

        }

    }
}