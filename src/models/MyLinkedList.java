package models;

import models.interfaces.MyList;

import java.util.Comparator;
import java.util.Iterator;

/**
 * A list where each element has a reference to the next and previous element.
 * @param <T> generic value
 */
public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Links a new element to the linked list.
     * If the link is the first one, it will be the head, if last a tail.
     * @param element element to be added
     */
    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setPrevious(traverse());
            traverse().setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    /**
     * Traverses specified index amount from the head and sets the new element.
     * @param index   index of the element to replace
     * @param element element to be set at the specified position
     */
    @Override
    public void set(int index, T element) {
        check(index);
        traverse(index).setElement(element);
    }

    /**
     * Inserts new element between two nodes.
     * @param index   the position to insert the element at
     * @param element the element to be inserted at the specified position
     */
    @Override
    public void add(int index, T element) {
        check(index);
        if (index == 0) {
            addFirst(element);
        } else if (index == length - 1) {
            addLast(element);
        } else {
            MyNode<T> newNode = new MyNode<>(element);
            MyNode<T> next = traverse(index);
            MyNode<T> previous = traverse(index-1);
            previous.setNext(newNode);
            newNode.setNext(next);
            next.setPrevious(newNode);
            length++;
        }
    }

    /**
     * Adds new node at the start by creating new head.
     * @param element the element to be inserted
     */
    @Override
    public void addFirst(T element) {
        MyNode<T> temp = head;
        head = new MyNode<>(element);
        head.setNext(temp);
        length++;
    }

    /**
     * Adds new node at the end by creating new tail.
     * @param element the element to be inserted
     */
    @Override
    public void addLast(T element) {
        add(element);
    }

    /**
     * Gets the element at the specified index by traversing from the head.
     * @param index index of the position you want to get the element from
     * @return the element inside the node at the specified index
     */
    @Override
    public T get(int index) {
        check(index);
        return traverse(index).getElement();
    }

    /**
     * Gets the element of the head.
     * @return the element of the head
     */
    @Override
    public T getFirst() {
        check(0);
        return head.getElement();
    }

    /**
     * Gets the element of the tail.
     * @return the element of the tail
     */
    @Override
    public T getLast() {
        check(length - 1);
        return tail.getElement();
    }

    /**
     * Removes the node at the specified index by making its previous node reference his next node.
     * If the specified index is head or tail, it changes them respectively.
     * @param index the index to remove the element at
     */
    @Override
    public void remove(int index) {
        check(index);
        if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            traverse(index).getPrevious().setNext(traverse(index + 1));
            length--;
        }
    }

    /**
     * Removes the first node.
     */
    @Override
    public void removeFirst() {
        head = head.getNext();
        length--;
    }

    /**
     * Removes the last node.
     */
    @Override
    public void removeLast() {
        tail = tail.getPrevious();
        length--;
    }

    /**
     * Sorts the linked list by swapping its elements using bubble sort and comparator passed as a parameter. <br>
     * O(n^2) time complexity.
     * @param cmp the comparator
     */
    @Override
    public void sort(Comparator<T> cmp) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                MyNode<T> current = traverse(j);
                MyNode<T> afterCurrent = traverse(j+1);
                if (cmp.compare(current.getElement(), afterCurrent.getElement()) > 0) {
                    T temp = current.getElement();
                    current.setElement(afterCurrent.getElement());
                    afterCurrent.setElement(temp);
                }
            }
        }
    }

    /**
     * Returns the index of specified element, -1 if not found.
     * @param object the object you want to find the index of in the sequence
     * @return index of the specified element or -1
     */
    @Override
    public int indexOf(Object object) {
        return findIndexOfElement(object);
    }

    /**
     * Returns the index of the last occurrence of the specified element.
     * @param object the object you want to find the last occurrence of
     * @return the index of the last occurrence of the specified element.
     */
    @Override
    public int lastIndexOf(Object object) {
        return findLastIndexOfElement(object);
    }

    /**
     * Find out if the object exists or not.
     * @param object the object to determine if it exists or not
     * @return true or false
     */
    @Override
    public boolean exists(Object object) {
        return contains(object);
    }

    /**
     * Returns linked list as a primitive array by traversing through nodes.
     * @return primitive array
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;
        int index = 0;
        while (current.hasNext()) {
            array[index++] = current.getElement();
            current = current.getNext();
        }

        return array;
    }

    /**
     * Clears the linked list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Returns the number of elements in the linked list.
     * @return the length
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Returns iterator to be used.
     * @return the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> iterator = head;
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                T element = iterator.getElement();
                iterator = iterator.getNext();
                return element;
            }
        };
    }

    /**
     * Private method that checks if the given index exists in the array list.
     * @param index the index to be checked
     */
    private void check(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds in an array with a size of " + length);
        }
    }

    /**
     * Private method that returns the node at specified index by traversing to it from the head. <br>
     * O(n) time complexity.
     * @param index the index to traverse to
     * @return the node at that specified index
     */
    private MyNode<T> traverse(int index) {
        MyNode<T> next = head;
        for (int i = 0; i < index; i++) {
            next = next.getNext();
        }

        return next;
    }

    /**
     * Private method that returns the node at the end by traversing to it from the head.
     * O(n) time complexity.
     * @return the node at the end
     */
    private MyNode<T> traverse() {
        MyNode<T> next = head;
        while (next.hasNext()) {
            next = next.getNext();
        }

        return next;
    }

    /**
     * Finds the index of the specified element. <br>
     * O(n) time complexity.
     * @param element the element to find the index of
     * @return the index of the specified element, -1 if not found
     */
    private int findIndexOfElement(Object element) {
        int index = 0;
        MyNode<T> current = head;
        while(current.hasNext()) {
            if (current.getElement().equals(element)) {

                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    /**
     * Finds the last occurrence of the specified element. <br>
     * O(n) time complexity.
     * @param element the element to find the last occurrence of
     * @return the index of last occurrence
     */
    private int findLastIndexOfElement(Object element) {
        int index = -1;
        int temp = 0;
        MyNode<T> current = head;
        while(current.hasNext()) {
            if (current.getElement().equals(element)) {
                index = temp;
            }
            current = current.getNext();
            temp++;
        }

        return index;
    }

    /**
     * Returns true if the linked list contains a specified element, false if not. <br>
     * O(n) time complexity.
     * @param element the element to search
     * @return true or false
     */
    private boolean contains(Object element) {
        MyNode<T> current = head;
        while(current.hasNext()) {
            if (current.getElement().equals(element)) {

                return true;
            }
            current = current.getNext();
        }

        return false;
    }
}
