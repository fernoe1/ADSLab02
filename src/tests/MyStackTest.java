package tests;

import models.MyArrayList;
import models.MyStack;

/**
 * Default test for MyStack.
 */
public class MyStackTest {
    public static void startTest() {
        MyStack<Integer> stack = new MyStack<>(new MyArrayList<>());
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("My Stack");
        System.out.println("---------------------------------------------");
        System.out.println();

        // inserting elements
        System.out.println("Pushing 1, 2, 3, 4, and 5");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size: " + stack.size());

        // testing main methods
        System.out.println("Popping the stack: " + stack.pop());
        System.out.println("Peeking at the new top: " + stack.peek());
        System.out.println("New size: " + stack.size());
        System.out.println("Is it empty? " + stack.empty());
    }
}
