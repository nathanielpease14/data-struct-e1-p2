// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Deque<Type> {
    private final ArrayDeque<Type> data;

    public Deque() {
        data = new ArrayDeque<>();
    }
    /**
     * Looks at element that is the first in the deque without removing it
     * from the deque.
     *
     * @return the character at the head of the deque
     * @throws NoSuchElementException if deque is empty
     */
    public Type pollFirst() {
        return data.getFirst();
    }

    /**
     * Looks at element that is the last in the deque without removing it
     * from the deque.
     *
     * @return the character at the head of the deque
     * @throws NoSuchElementException if deque is empty
     */
    public Type pollLast() {
        return data.getLast();
    }

    /**
     * Removes and returns element that is the first in the deque
     *
     * @return the character at the head of the deque
     * @throws NoSuchElementException if deque is empty
     */
    public Type removeFirst() {
        return data.removeFirst();
    }

    /**
     * Removes and returns element that is the last in the deque
     *
     * @return the character at the tail of the deque
     * @throws NoSuchElementException if deque is empty
     */
    public Type removeLast() {
        return data.removeLast();
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param input the character to add
     * @throws NullPointerException if the specified input is null
     */
    public void addFirst(Type input) {
        data.addFirst(input);
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param input the character to add
     * @throws NullPointerException if the specified input is null
     */
    public void addLast(Type input) {
        data.addLast(input);
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    public int size() {
        return data.size();
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
