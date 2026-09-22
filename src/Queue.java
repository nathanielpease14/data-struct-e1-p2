// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Queue<Type> {
    private final ArrayDeque<Type> data;

    public Queue() {
        data = new ArrayDeque<>();
    }

    /**
     * Looks at element that is the first in the queue without removing it
     * from the queue.
     * @throws NoSuchElementException if queue is empty
     */
    public Type front() {
        return data.getFirst();
    }

    /**
     * Removes and returns element that is the first in the queue
     * @throws NoSuchElementException if queue is empty
     */
    public Type dequeue() {
        return data.removeFirst();
    }

    /**
     * Inserts the specified element at the end of this queue.
     * @param input the character to add
     * @throws NullPointerException if the specified input is null
     */
    public void enqueue(Type input) {
        data.addLast(input);
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns whether the queue is empty or not
     *
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return size() == 0;
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
