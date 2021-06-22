package L6Stack;

import java.util.Scanner;

public class ReverseString {
	static final int MAX = 1000; 
	int top;
	String a[]= new String[MAX];
   
	boolean isEmpty() 
	{ 
		return (top < 0);
	} 
	ReverseString()
	{ 
		top = -1;
		for (int i=0;i<MAX;i++)
			a[i]=" ";
	} 

	public boolean push(String str)
	{ 
		if (top >= (MAX - 1)){
			System.out.println("Stack Overflow"); 
			return false; 
		} 
		else { 
			top++;
			a[top] = str;
			return true; 
		}
	} 

	public void pop()
	{ 
		if (top < 0)  
			System.out.println("Stack Underflow"); 
		else {
			System.out.println(a[top]+" is popped from stack");
			a[top]= " ";
			top--;
			System.out.println("Now the top is "+ top);

		}

	}
	void printStr() {
		if (top < 0)
			System.out.println("Stack Underflow");
		else {
			System.out.print(a[top]);
			a[top] = " ";
			top--;
		}
	}

	public String peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return "";
		} else {
			String x = a[top];
			return x;
		}
	}
	void string_reversal(String str) {
		String[] tmp = new String[str.length()];
		for (int i = 0;i<str.length();i++) {
			push(String.valueOf(str.charAt(i)));
		}
		System.out.print("Reversed String: ");
		for (int i = 0;i<str.length();i++) {
		       printStr();
		}
	}


// Driver code 
	public static void main(String args[]) 
	{ 
		ReverseString s = new ReverseString();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter String you want to reverse: ");
		String str = in.nextLine();
		s.string_reversal(str);

	} 
} 
