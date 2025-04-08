import tests.*;

import java.util.Scanner;

/**
 * User interface where you can run default tests of physical and logical data structures.
 */
public class UserInterface {
    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    public static void start(Scanner sc) {
        while (true) {
            System.out.println("[1] Run default MyArrayList test");
            System.out.println("[2] Run default MyLinkedList test");
            System.out.println("[3] Run default MyStack test");
            System.out.println("[4] Run default MyQueue test");
            System.out.println("[5] Run default MyMinHeap test");
            System.out.println("[0] Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    MyArrayListTest.startTest();
                    System.out.println();
                    break;
                case 2:
                    MyLinkedListTest.startTest();
                    System.out.println();
                    break;
                case 3:
                    MyStackTest.startTest();
                    System.out.println();
                    break;
                case 4:
                    MyQueueTest.startTest();
                    System.out.println();
                    break;
                case 5:
                    MyMinHeapTest.startTest();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}