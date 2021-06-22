package L6Stack;

public class BalancedBraces {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    boolean flag = false;
    static final int MAX = 1000;
    int top;
    String a[]= new String[MAX];

    BalancedBraces()
    {
        top = -1;
        for (int i=0;i<MAX;i++)
            a[i]=" ";
    }

    public boolean push(String str)
    {
        if (top >= (MAX - 1)){
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
        if (top < 0) {
            flag = true;
        }
        else {
            a[top]= " ";
            top--;

        }

    }

        void checkBalance(String str) {
            for (int i = 0;i<str.length();i++) {
                if (str.charAt(i) == '{') {
                    push(String.valueOf(str.charAt(i)));
                }
                else if (str.charAt(i) == '}') {
                    pop();
                }

            }
            if(flag) System.out.println(ANSI_RED+ "Not Balanced" + ANSI_RESET);
            else
            System.out.println(ANSI_GREEN +  "Balanced" + ANSI_RESET);
        }


    public static void main(String[] args) {
        BalancedBraces BB = new BalancedBraces();
        //Balance Case
        BB.checkBalance("{{}}SDasd");
        /*Not Balance Case
            BB.checkBalance("}{}}DSdasd");
         */
    }
}
