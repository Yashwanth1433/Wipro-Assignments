package dsa.tasks;

public class DynamicArray {

    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 10;  
        this.array = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    public void add(int element) {
        if (size == capacity) {
            resizeArray();
        }
        array[size++] = element;
    }

    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resizeArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resizeArray() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);

        System.out.println("Initial array:");
        arr.print(); 

        arr.insert(2, 25);
        System.out.println("Array after inserting 25 at index 2:");
        arr.print();  

        arr.removeAt(3);
        System.out.println("Array after removing element at index 3:");
        arr.print();  

        System.out.println("Element at index 1: " + arr.get(1)); 

        arr.set(0, 5);
        System.out.println("Array after setting element at index 0 to 5:");
        arr.print();  
    }
}