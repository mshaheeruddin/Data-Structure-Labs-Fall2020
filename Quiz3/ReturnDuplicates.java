package Quiz3;

public class ReturnDuplicates {
    //quadratic
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
            if(arr[index] == arr[i]) {
                System.out.print("Duplicate is: ");
                System.out.println(arr[i]);
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    //loglinear: heapsort
    public void sort(int arr[]) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (arr[l] == arr[largest]) {
            System.out.print("Duplicate is: ");
            System.out.print(arr[l]);
        }
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (arr[r] == arr[largest]) {
            System.out.println("Duplicate is");
            System.out.print(arr[r]);
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }
    }



    public static void main(String[] args) {
        ReturnDuplicates rD = new ReturnDuplicates();
        int[] arr = {3, 2, 4, 3};
        rD.selectionSort(arr);
       //rD.sort(arr);
    }
}
