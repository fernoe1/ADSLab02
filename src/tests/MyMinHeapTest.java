package tests;

import models.MyMinHeap;

import java.util.Comparator;

/**
 * Default test for MyMinHeap.
 */
public class MyMinHeapTest {
    public static void startTest() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>((Comparator<Integer>) Comparator.naturalOrder());
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("My Min Heap");
        System.out.println("---------------------------------------------");
        System.out.println();

        // testing insert
        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(12);
        System.out.println("Added 20, 15, and 12 to the heap");
        System.out.println("The min root element: " + minHeap.getExtremum());

        // testing extract
        minHeap.extractExtremum();
        System.out.println("Extracted the root from the heap");
        System.out.println("New min root element: " + minHeap.getExtremum());

        // testing size
        System.out.println("Heap size: " + minHeap.size());

        // testing empty
        System.out.println("Heap is empty? " + minHeap.empty());
    }
}
