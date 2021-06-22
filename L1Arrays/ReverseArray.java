package L1Arrays;
import java.io.*;
import java.util.Arrays;

/*
 * Author : Muhammad Shaheer Uddin
 * ERP #: 19757
 */

public class ReverseArray {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Taking user input for an integer or array length
        System.out.print("Enter an Integer: ");
        int integer = Integer.parseInt(reader.readLine());

        System.out.println("Enter " + integer + " values:" );
        int[] values;
        values = new int[integer];
        //User input for array values
        for (int i = 0;i < integer; i++) {
            System.out.print("Value # " + (i+1) + ": ");
            values[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println("Original Array: " + Arrays.toString(values));
        //Reverse by swapping

        for (int i = 0;i < values.length/2; i++) {
            int tempVar = values[i];
            values[i] = values[values.length-i-1];
            values[values.length-i-1] = tempVar;
        }
        System.out.print("Reversed Array: " + Arrays.toString(values));
    }
}
