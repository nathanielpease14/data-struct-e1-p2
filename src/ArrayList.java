// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    static protected final int DEFAULT_CAPACITY = 10;

    private int length;
    private Object[] data;

    /**
     * Simple default constructor. If unsure, just use this.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor where you provide a desired initial capacity
     * @param initialCapacity the initial capacity of the ArrayList
     */
    public ArrayList(int initialCapacity) {
        length = 0; // not necessary
        data = new Object[Integer.max(initialCapacity, DEFAULT_CAPACITY)];
    }

    /**
     * Constructor where you provide initial data in the form of an ArrayList
     * @param data the initial data to be stored in the ArrayList
     */
    public ArrayList(ArrayList<T> data) {
        length = data.size();
        this.data = new Object[Integer.max(DEFAULT_CAPACITY, length)];
        for (int i = 0; i < length; i++) {
            this.data[i] = data.get(i);
        }
    }

    /**
     * Constructor where you provide initial data in the form of an array
     * @param data the initial data to be stored in the ArrayList
     */
    public ArrayList(T[] data) {
        length = data.length;
        this.data = data;
        int newCap = Integer.max(newCapacity(), DEFAULT_CAPACITY);
        resize(newCap); // lol what is this?? Sure..
    }

    /**
     * The current capacity of elements that can be stored without resizing.
     * @return the current capacity
     */
    public int capacity() {
        return data.length;
    }

    private int newCapacity() {
        return capacity() + capacity() / 2;
    }

    /*
     * I don't like this method. I should inline it
     */
    private void checkIndex(int index, int ceiling) {
        if (index < 0 || index >= ceiling) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Ceiling: %d", index, ceiling));
        }
    }

    private void copyTo(Object[] target) {
        final int maxIndex = Integer.min(length, target.length);
        for (int i = 0; i < maxIndex; i++) {
            target[i] = data[i];
        }
    }

    private void resize() {
        resize(newCapacity());
    }

    private void resize(int newCap) {
        Object[] newData = new Object[newCap];
        copyTo(newData);
        data = newData;
    }

    /**
     * The current number of elements stored in the ArrayList
     * @return the size
     */
    public int size() {
        return length;
    }

    /**
     * Insert an element into the ArrayList at a given index
     * @param index the index to insert
     * @param element the element to insert
     */
    public void add(int index, T element) {
        checkIndex(0, length + 1);
        if (length >= capacity()) {
            resize();
        }
        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        length += 1;
    }

    /**
     * Append an element to the end of the ArrayList
     * @param element the element to append
     * @return true
     */
    public boolean add(T element) {
        add(length, element);
        return true;
    }

    /**
     * Clear out an ArrayList
     * More efficient than initializing a new ArrayList
     */
    public void clear() {
        for (int i = 0; i < length; i++) {
            set(i, null);
        }
        length = 0;
    }

    /**
     * Get the value stored at the given index
     * @param index the index of the element you want to return
     * @throws IndexOutOfBoundsException if index is out of bounds
     * @return the element stored at index
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index, length);
        return (T) data[index];
    }

    /**
     * Set the value to be stored at the given index
     * @param index the index of the element you want to set
     * @param element the element to set
     * @throws IndexOutOfBoundsException if index is out of bounds
     * @return the previous value stored at index
     */
    public T set(int index, T element) {
        checkIndex(index, length);
        T temp = get(index);
        data[index] = element;
        return temp;
    }

    /**
     * Remove the value stored at the given index
     * @param index the index of the element you want to remove
     * @throws IndexOutOfBoundsException if index is out of bounds
     * @return the previous value stored at index
     */
    public T remove(int index) {
        checkIndex(index, length);
        T result = get(index);
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length -= 1;
        return result;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterator<T> {
        int index;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not Allowed");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not Allowed");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Not Allowed");
    }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
