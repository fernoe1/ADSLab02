package models;

import models.interfaces.IMyHeap;

import java.util.Comparator;

public class MyMinHeap<T> implements IMyHeap<T> {
    private MyArrayList<T> list;
    private Comparator<T> cmp;

    public MyMinHeap(Comparator<T> cmp) {
        list = new MyArrayList<>();
        this.cmp = cmp;
    }

    /**
     * Returns whether the min heap is empty or not using size() method.
     * @return true or false
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the size of the heap.
     * @return the size
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Gets the root element of the heap. <br>
     * O(1) time complexity.
     * @return the root element
     */
    @Override
    public T getExtremum() {
        return list.get(0);
    }

    /**
     * Retrieves the root of the heap and deletes it.
     * @return the root
     */
    @Override
    public T extractExtremum() {
        T extremum = getExtremum();
        list.set(0, list.getLast());
        list.removeLast();
        heapify(0);

        return extremum;
    }

    /**
     * Adds element to the heap
     * @param element the element
     */
    @Override
    public void insert(T element) {
        list.add(element);
        traverseUp(list.size() - 1);
    }

    /**
     * Method that makes the array fit the heap requirements
     * by starting heapify from the specified index. <br>
     * O(log(n)) time complexity.
     * @param index the index to start the heapify from
     */
    private void heapify(int index) {
        // Checking if the index is a leaf
        int size = list.size();
        if (size / 2 <= index && index <= size - 1) {
            return;
        }

        // Finding index of smallest element
        int smallest = index;
        int leftChildIndex = leftChildOf(index);
        int rightChildIndex = rightChildOf(index);
        if (leftChildOf(index) < size && cmp.compare(list.get(leftChildIndex), list.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < size && cmp.compare(list.get(rightChildIndex), list.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }

        // If smallest is different from the index swap and continue to heapify
        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    /**
     * Traverses up from the index to the root. <br>
     * O(log(n)) time complexity.
     * @param index the index to start the traverse up from
     */
    private void traverseUp(int index) {
        // If it fits the requirements or its root stop
        if (cmp.compare(list.get(parentOf(index)), list.get(index)) < 0 || index == 0) {
            return;
        }

        // If not swap and continue traversing up
        swap(parentOf(index), index);
        traverseUp(parentOf(index));
    }

    /**
     * Returns left child of a node.
     * @param index the index of a node
     * @return the index of the left child
     */
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns right child of a node.
     * @param index the index of a node
     * @return the index of the right child
     */
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    /**
     * Returns parent of a node.
     * @param index the index of a node
     * @return the index of the parent
     */
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    /**
     * Swaps elements in specified two indexes.
     * @param i1 the first index
     * @param i2 the second index
     */
    private void swap(int i1, int i2) {
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
}
