/**
 * 
 * Creates a tri-prong-min-heap that assumes that the user
 * does not go over the size that is inputed
 * through the Array.
 * 
 * @author pjp5228
 *
 * @param <E>
 */
public class TernaryHeap<E extends java.lang.Comparable<E>> {
    //Generic array that stores all the data of the heap
    private E[] myHeap = null;
    //Variable that stores the size of the heap, NOT the size of myHeap
    private int size = 0;
    /**
     * Constructor that takes an array that declares the size 
     * and the data type
     * @param init
     */
    public TernaryHeap(E[] init) {
        myHeap = init;
    }
    /**
     * Method that takes an item and inserts it into the heap
     * by adding it to the end, and "fixing" the heap by
     * swapping with the parent if the two are out of order
     * @param item
     */
    public void insert(E item) {
        //Increments the size
        size++;
        //Adds the item to the end of the heap
        myHeap[size - 1] = item;
        //Fix the heap 
        add(size - 1);
    }


private void add(int index) {
    //If the index is not the head
    if(index != 0) {
        //get the parent of the index
        int parent = getParent(index);
        //If the parent is less than the index
        if(myHeap[parent].compareTo(myHeap[index]) > 0) {
            //Swap them
            E tmp = myHeap[parent];
            myHeap[parent] = myHeap[index];
            myHeap[index] = tmp;
            //Do the same with the parent
            add(parent);
        }
    }
}
/**
 * 
 * Mathematically finds the parent of an index
 * 
 * @param c
 * @return The parent of a index
 */
private int getParent(int c) {
    return (c - 1)/3;
}
/**
 * 
 * Mathematically finds the left child of a parent
 * 
 * @param p
 * @return The left child
 */
private int getLeft(int p) {
    return (3 * p) + 1;
}
/**
 * 
 * Mathematically finds the middle child of a parent
 * 
 * @param p
 * @return The middle child
 */
private int getMiddle(int p) {
    return (3 * p) + 2;
}
/**
 * 
 * Mathematically finds the right child of a parent
 * 
 * @param p
 * @return The right child
 */
private int getRight(int p) {
    return (3 * p) + 3;
}

public E remove() throws UnderflowException {
    //Return null if the heap is empty
    if(size == 0)
        throw new UnderflowException("Cannot remove from an empty heap!");
    //Remove the only value if the heap size is 1
    if(size == 1){
        size--;
        E temp = myHeap[0];
        myHeap[0] = null;
        //Return the removed value
        return temp;
    }
    //If the heap size is > 1
    else {
        //Decrement the size
        size--;
        E temp = myHeap[0];
        myHeap[0] = myHeap[size];
        //Fix the heap
        fixHeap(0);
        //Return the removed value
        return temp;
    }
}

private void fixHeap(int index){
    //Set the value to the minimum index
    int min = minimum(index);
    //If the min is >= 0
    if(min >= 0){
        //Swap the index and the min
        E temp = myHeap[index];
        myHeap[index] = myHeap[min];
        myHeap[min] = temp;
        //Fix it with the parent
        fixHeap(min);
    }
}
/**
 * Returns the index of the smallest child
 * @param index
 * @return The index of the smallest child
 */
private int minimum(int index) {
    //Variables that store the indexes of the children
    int leftIndex = getLeft(index);
    int middleIndex = getMiddle(index);
    int rightIndex = getRight(index);
    //Go as long as the indexes are <= the size of the heap
    if(leftIndex <= size && middleIndex <= size && rightIndex <= size)
        //Go as long as each index is > 0
        if(leftIndex > 0 && middleIndex > 0 && rightIndex > 0)
            //If the left index is the smallest, return it
            if(myHeap[leftIndex].compareTo(myHeap[middleIndex]) <= 0 && 
            myHeap[leftIndex].compareTo(myHeap[rightIndex]) <= 0)
                return leftIndex;
            //If the middle index is the smallest, return it
            else if(myHeap[middleIndex].compareTo(myHeap[leftIndex]) <= 0 && 
                    myHeap[middleIndex].compareTo(myHeap[rightIndex]) <= 0)
                return middleIndex;
            //If the right index is the smallest, return it
            else if(myHeap[rightIndex].compareTo(myHeap[leftIndex]) <= 0 && 
                    myHeap[rightIndex].compareTo(myHeap[middleIndex]) <= 0)
                return rightIndex;
    //Return -1 if any one of the indexes is invalid
    return -1;
}
/**
 * Returns the size of the Heap.
 * @return Size
 */
 public int size() {
    return size;
}
/**
 * Prints the heap out, used for testing purposes.
 * @return String of heap
 */
 public String toString(){
     String finalize = "";
     for(int i = 0; i < size; i++)
         finalize += myHeap[i] + " ";
     return finalize;
 }
}