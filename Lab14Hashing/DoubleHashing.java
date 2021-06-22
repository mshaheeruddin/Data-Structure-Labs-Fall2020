package Lab14Hashing;

public class DoubleHashing extends LinearProbe {
    public DoubleHashing() {

    }

    public int hashCode2(char key) {
        return (key % 3) + 1;
    }

    public void put(char key, Integer value) {
        int index = hashCode1(key);
        HTObject item = new HTObject();
        item.key = key;
        item.value = value;
        if (arr[index] == null) {
            arr[index] = item;
            System.out.println("Key is: " + key + " and value is: " + value + " which is at index: " + index + " of array");
        } else {
            int oldIndex = 0;
            while (arr[index] != null) {
                oldIndex = index;
                index = (index + hashCode2(key)) % ARR_SIZE;
            }

            arr[index] = item;
            System.out.println("Collision occurred here because, key: " + key + " wanted to sit at index: " + oldIndex + " which was already occupied, so collision handled successfully!");
            System.out.println("Key is: " + key + " and value is: " + value + " which is at index: " + index + " of array");

        }

    }
}