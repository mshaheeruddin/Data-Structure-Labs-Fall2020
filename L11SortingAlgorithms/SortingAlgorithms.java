package L11SortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {
    public int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
    //BinarySearch Based Insertion Sort
    void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i<n; i++) {
            int key = arr[i];
            int insPos = findPosition(arr,0,i-1,key);
            for (int j = i - 1; j >= insPos; --j) {
                arr[j + 1] = arr[j];
            }
            arr[insPos] = key;
        }
    }
    //SelectionSort
    int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    int i = 0;
    int[][] sortMatrixByRow (int[][] matrix) {
        while (i != matrix.length) {
            int[] arr = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                arr[j] = matrix[i][j];
            }
            arr = selectionSort(arr);
            for (int k = 0; k < arr.length; k++) {
                matrix[i][k] = arr[k];
            }
            i++;
        }
        return matrix;
    }
    int m = 0;
    int[][] sortMatrixByColumn (int[][] matrix) {
        while (m != matrix[0].length) {
            int[] arr1 = new int[matrix.length];

            for (int j = 0; j < matrix.length; j++) {
                arr1[j] = matrix[j][m];
            }
            arr1 = selectionSort(arr1);
            for (int k = 0; k < arr1.length; k++) {
                matrix[k][m] = arr1[k];
            }
            m++;
        }
        return matrix;
    }


    public static void main(String[] args) {
        SortingAlgorithms is = new SortingAlgorithms();
        /*
        int[] arr = {6,2,1,4,5,3};
        is.selectionSort(arr);
        for (int i = 0; i<arr.length;i++) {
            System.out.print(arr[i] +  " ");
        }
        System.out.println();

         */
        int[][] array = {{5,6,7,1,3,2,4},{7,6,5,3,1,4,2}};
        // System.out.println(Arrays.deepToString(is.sortMatrixByRow(array)));
       // System.out.println(Arrays.deepToString(is.sortMatrixByColumn(array)));


    }
}
