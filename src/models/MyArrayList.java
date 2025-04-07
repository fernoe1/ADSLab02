package models;

import models.interfaces.MyList;

import java.util.Iterator;
import java.util.Comparator;

/**
 * Dynamic array that increases its size as it reaches its limit. <br>
 * Implementation of MyList.
 * @param <T> generic value
 */
public class MyArrayList<T> implements MyList<T> {
    private T[] elements;
    private int length;

    public MyArrayList() {
        elements = (T[]) new Object[10];
        length = 0;
    }

    /**
     * Adds the element to the array,
     * if the array is at its limit, it fires the increase size private method.
     * @param element element to be added
     */
    @Override
    public void add(T element) {
        if (length == elements.length) {
            increaseSize();
        }

        elements[length++] = element;
    }

    /**
     * Sets the element at the specified index to a new element.
     * @param index   index of the element to replace
     * @param element element to be set at the specified position
     */
    @Override
    public void set(int index, T element) {
        check(index);
        elements[index] = element;
    }

    /**
     * Shifts elements to the right to create space at specified position and adds the element there.
     * @param index   the position to insert the element at
     * @param element the element to be inserted at the specified position
     */
    @Override
    public void add(int index, T element) {
        check(index);
        if (++length == elements.length) {
            increaseSize();
        }
        shiftRight(index);
        elements[index] = element;
    }

    /**
     * Shifts elements to the right and adds the element at the first place.
     * @param element the element to be inserted
     */
    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * Adds the element at the last position.
     * @param element the element to be inserted
     */
    @Override
    public void addLast(T element) {
        add(element);
    }

    /**
     * Returns the element at the specified index.
     * @param index index of the position you want to get the element from
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @return the element at the specified index
     */
    @Override
    public T get(int index) {
        check(index);
        return elements[index];
    }

    /**
     * Gets the first element in the array list.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @return the first element
     */
    @Override
    public T getFirst() {
        check(0);
        return elements[0];
    }

    /**
     * Returns the last element in the array list.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @return the last element
     */
    @Override
    public T getLast() {
        check(length - 1);
        return elements[length - 1];
    }

    /**
     * Removes the element at the specified index by shifting elements to the right from that index.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @param index the index to remove the element at
     */
    @Override
    public void remove(int index) {
        check(index);
        shiftLeft(index);
        length--;
    }

    /**
     * Removes the first element in the array list by shifting elements to the right from the start.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last element in the array list.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void removeLast() {
        remove(length - 1);
    }

    /**
     * Sorts the array list using comparator passed as a parameter.
     */
    @Override
    public void sort(Comparator<T> cmp) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (cmp.compare(elements[j], elements[j + 1]) > 0) {
                    T temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Returns index of the object
     * @param object the object you want to find the index of in the sequence
     * @return the index of the first occurrence of the object or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        return findIndexOfElement(object);
    }

    /**
     * Returns last index of the object
     * @param object the object you want to find the last occurrence of
     * @return the index of the last occurrence of the object, -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        return findLastIndexOfElement(object);
    }

    /**
     * Returns true or false depending on if the object exists or not.
     * @param object the object to determine if it exists or not
     * @return true or false
     */
    @Override
    public boolean exists(Object object) {
        return contains(object);
    }

    /**
     * Returns the array list as a primitive array.
     * @return the primitive array
     */
    @Override
    public Object[] toArray() {
        return elements;
    }

    /**
     * Creates a new array of the initial size of 10,
     * therefore clearing out every element and creating a new empty array.
     */
    @Override
    public void clear() {
        elements = (T[]) new Object[10];
        length = 0;
    }

    /**
     * Returns the number of elements in the array.
     * @return the number of elements in the array
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Returns iterator to use.
     * @return the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return elements[index++];
            }
        };
    }

    /**
     * Private method that creates a new array with double of the original size,
     * copies elements from the original and changes
     * the reference to the new array resulting in an array with larger size.
     */
    private void increaseSize() {
        T[] temp = (T[]) new Object[elements.length * 2];
        for (int i = 0; i < length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    /**
     * Private method that checks if the given index exists in the array.
     * @param index the index to be checked
     */
    private void check(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds in an array with a size of " + length);
        }
    }

    /**
     * Private method that shifts elements to the left.
     * @param index the element to start the shift from
     */
    private void shiftLeft(int index) {
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i+1];
        }
    }

    /**
     * Private method that shifts elements to the right.
     * @param index the element to shift till
     */
    private void shiftRight(int index) {
        for (int i = length - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
    }

    /**
     * Finds the index of the specified element.
     * @param element the element to find the index of
     * @return the index of the specified element, -1 if not found
     */
    private int findIndexOfElement(Object element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {

                return i;
            }
        }

        return -1;
    }

    /**
     * Finds the last occurrence of the specified element.
     * @param element the element to find the last occurrence of
     * @return the index of last occurrence
     */
    private int findLastIndexOfElement(Object element) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Returns true if the array list contains a specified element, false if not.
     * @param element the element to search
     * @return true or false
     */
    private boolean contains(Object element) {
        for (int i = 0; i < length; i++) {
            if (element.equals(elements[i])) {

                return true;
            }
        }

        return false;
    }
}
