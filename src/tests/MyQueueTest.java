package tests;

import models.MyLinkedList;
import models.MyQueue;

/**
 * Default test for MyQueue.
 */
public class MyQueueTest {
    public static void startTest() {
        MyQueue<Integer> queue = new MyQueue<>(new MyLinkedList<>());
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("My Queue");
        System.out.println("---------------------------------------------");
        System.out.println();

        // enqueueing elements
        System.out.println("Enqueueing 1, 2, 3, 4, and 5");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Size: " + queue.size());

        // testing main methods
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Peeking at the new element at the front of the queue " + queue.peek());
        System.out.println("New ize: " + queue.size());
        System.out.println("Is it empty? " + queue.empty());
    }
}
