package L1Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 *Author : Muhammad Shaheer Uddin
 * ERP #: 19757
 */
public class ArithmeticQuiz {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String str = "y";
        String str1 = "y";
        while (str.equals(str1)) {
            int count = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Number of Questions:");
            int noOfQuestions = Integer.parseInt(reader.readLine());

            int[] key;
            key = new int[noOfQuestions];

            System.out.println("Enter Keys of Questions separated by commas:");
            String inStr = in.nextLine();

            for (int i = 0; i < key.length; i++) {
                String[] strArray = (inStr.split(","));
                key[i] = Integer.parseInt(strArray[i]);
            }
            //caution message
            System.out.println(ANSI_YELLOW + "ORDER MATTERS!;FIRST ANSWER CORRESPONDS TO FIRST KEY!" + ANSI_RESET);
            //input answers
            System.out.println("Enter Answers separated by commas:");
            String inStr2 = in.nextLine();
            for (int i = 0; i < noOfQuestions; i++) {
                String[] inStrArray = inStr2.split(",");
                int[] answer = new int[inStrArray.length];
                answer[i] = Integer.parseInt(inStrArray[i]);
                if (answer[i] == key[i]) {
                    count++;
                }
            }
            System.out.println("------------------RESULT-----------------------------");

            System.out.println("Number Of Correct Answers:" + count);
            System.out.println("Percentage of correct answers:" + count * 100 / noOfQuestions + "%");

            System.out.println("-----------------------------------------------------");
            System.out.println("Do you want to grade another quiz?y/n");

            str = reader.readLine();

        }
    }

}
