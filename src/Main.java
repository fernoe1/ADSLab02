import models.MyArrayList;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>();
        // testing my array list methods
        System.out.println("---------------------------------------------");
        System.out.println("My Array List");
        System.out.println("---------------------------------------------");
        System.out.println();

        // testing add and get
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println("Original integers:");
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        // testing add at index
        integers.add(1, 7);
        System.out.println("After adding 7 at index 1:");
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        // testing remove
        integers.remove(2);
        System.out.println("After removing element at index 2:");
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        // testing indexOf and lastIndexOf
        integers.add(10);
        System.out.println("First index of 10: " + integers.indexOf(10));
        System.out.println("Last index of 10: " + integers.lastIndexOf(10));

        // testing exists
        System.out.println("Does 1 exist? " + integers.exists(1));
        System.out.println("Does 1465 exist?" + integers.exists(1465));

        // testing sorting (alphabetical)
        integers.sort(Comparator.naturalOrder());
        System.out.println("After sort:");
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        // testing clear
        integers.clear();
        System.out.println("After clearing the integers size is: " + integers.size());

        // testing my linked list methods
        System.out.println("---------------------------------------------");
        System.out.println("My Linked List");
        System.out.println("---------------------------------------------");
        System.out.println();
    }
}