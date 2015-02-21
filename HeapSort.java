import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HeapSort {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    /**
     * Main method that reads a file, and adds all the data
     * to the heap. It then removes and prints the data out
     * in order. Currently only works for Integers
     * @param args
     */
    public static void main(String args[]) throws UnderflowException{
        Integer[] a = new Integer[8];
        //Creates a Ternary Heap or Integers, and passes Array a to it
        TernaryHeap<Integer> h = new TernaryHeap(a);
        //Checks that args is of the right length
        if(args.length != 1) {
            System.err.println("java <filepath>");
            System.exit(1);
        }
        //Creates a filepath, and a scanner
        File file = new File(args[0]);
        Scanner sc = null;
        //Checks that the path is valid
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            System.exit(1);
        }
        //While there is a line in the file that hasn't been read
        while (sc.hasNextLine()) {
            //Insert it into the Heap
            h.insert(sc.nextInt());
        }
        //Creates an index = to the size of the heap
        int index = h.size();
        //Loop through the heap, removing the next value in the list
        for(int i = 0; i < index; i++){
            //Prints out the value that is removed
            System.out.print(h.remove() + " ");
        }
        System.out.println();
        //Closes the scanner
        sc.close(); 
    }
}
