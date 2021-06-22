package L11SortingAlgorithms;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Rectangle {

    private int id;
    private int length;
    private int breadth;
    private String color;
    public Rectangle() {

    }

    public Rectangle(int id, int length,int breadth,String color) {
          this.id = id;
          this.length = length;
          this.breadth = breadth;
          this.color = color;
    }
    public int getId() {
        return id;
    }
    public int getLength() {
        return length;
    }
    public int getBreadth() {
        return breadth;
    }
    public String getColor() {
        return color;
    }


    public Rectangle[] bubbleSort(Rectangle[] arr) {
        int n = arr.length;
        Rectangle temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1].id > arr[j].id){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

   @Override
   public String toString() {
        return String.valueOf(getId()) + "," + getLength() + "," + getBreadth() + "," + getColor();
    }


    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Rectangle[] r = new Rectangle[3];
        r[0] = new Rectangle(3,5,6,"Yellow");
        r[1] = new Rectangle(1,7,9,"Blue");
        r[2] = new Rectangle(2,1,3,"Red");

        System.out.println(Arrays.deepToString(rectangle.bubbleSort(r)));

    }

}
