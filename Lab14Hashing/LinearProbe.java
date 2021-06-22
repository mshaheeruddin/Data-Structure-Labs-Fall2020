package Lab14Hashing;

public class LinearProbe {

	public static class HTObject {
        public char key;
        public Integer value;
        public String toString() {
            return "("+key+","+value+") ";
        }
    }
 
	// length dependent
	public int hashCode1(char key) {
              return 11*(key)%ARR_SIZE;
		}

	// Open Addressing collision is being resolved Linear Prob
    public static final int ARR_SIZE = 16;// Separate Chaining
    public HTObject[] arr = new HTObject[ARR_SIZE];
 
    public LinearProbe() {
        //init vals in array
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = null;
        }
    }
 
    public void put(char key, Integer value) {
        int index = hashCode1(key);
        HTObject item= new HTObject();   
        item.key=key;
        item.value=value;
        if (arr[index]==null) {
            arr[index] = item;
            System.out.println("Key is: " + key +" and value is: " +value+ " which is at index: " +index+ " of array");
        }
        else
        {   int oldIndex = 0;
        	while(arr[index]!=null)
        		 {   oldIndex = index;
        		     index++;
        		  index= index % ARR_SIZE ;}

        	arr[index]= item;
            System.out.println("Collision occurred here because, key: " + key + " wanted to sit at index: " +oldIndex+" which was already occupied, so collision handled successfully!" );
            System.out.println("Key is: " + key +" and value is: " +value+ " which is at index: " +index+ " of array");

        }
        	
        	
        }
        
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearProbe lp= new LinearProbe();
		lp.put('R', 1);
        lp.put('E', 2);
        lp.put('P', 3);
        lp.put('U', 4);
        lp.put('B', 5);
        lp.put('L', 6);
        lp.put('I', 7);
        lp.put('C', 8);
        lp.put('A', 9);
        lp.put('N', 10);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-----------------------Double Hashing!-----------------------------------");
        System.out.println("-------------------------------------------------------------------------");

        DoubleHashing dh = new DoubleHashing();
        dh.put('A', 1);
        dh.put('N', 2);
        dh.put('O', 3);
        dh.put('T', 4);
        dh.put('H', 5);
        dh.put('E', 6);
        dh.put('R', 7);
        dh.put('X', 8);
        dh.put('M', 9);
        dh.put('P', 10);
        dh.put('L', 11);
        dh.put('E', 12);






    }

}
