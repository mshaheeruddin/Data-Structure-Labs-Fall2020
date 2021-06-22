package L1Arrays;

import java.util.Scanner;
/*
 *Author : Muhammad Shaheer Uddin
 * ERP #: 19757
 */

class Box {
    //Row Sum
    public Box() {

    }
    public int sumOfRowsOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum = 0;
            for (int col = 0; col < matrix[row].length; col++)
                sum = sum + matrix[row][col];
        }
        return sum;
    }

    //Col Sum
    public int sumOfColumnOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            sum = 0;
            for (int row = 0; col < matrix[row].length; col++)
                sum = sum + matrix[row][col];
        }
        return sum;
    }

    public int sumOfMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum = sum + matrix[row][row];
        }
        return sum;
    }

    public int sumOfOtherDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sum = sum + matrix[row][row];
        }
        return sum;
    }

    public String isMagicBox(int[][] m) {
        int row = sumOfRowsOfMatrix(m);
        int col = sumOfColumnOfMatrix(m);
        int mainD = sumOfMainDiagonal(m);
        int otherD = sumOfOtherDiagonal(m);

        if ((row == col) && (mainD == otherD) && (row == mainD) && (row == otherD) && (col == mainD) && (col == otherD)) {
            return "Yes this is magic box!";
        } else return "This is NOT a magic box!";
    }

}
public class MagicBox {
    public static void main(String[] args) {
        java.util.Scanner input = new Scanner(System.in);
        System.out.print("Enter size of Square:");

        int size =  input.nextInt();
        System.out.println("Please enter square values:");
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextInt();
            }
        }
       Box mbox = new Box();
        String str = mbox.isMagicBox(matrix);
        System.out.println(str);
    }
}