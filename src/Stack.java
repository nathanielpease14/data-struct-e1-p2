// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<Type> {
    private final ArrayList<Type> data;

    public Stack() {
        data = new ArrayList<>();
    }


    /**
     * Pushes an character onto the top of this stack.
     *
     * @param input the character to be pushed onto this stack.
     */
     public void push(Type input) {
         data.add(input);
     }

    /**
     * Removes the character at the top of this stack and returns that
     * character as the value of this function.
     *
     * @return  The character at the top of this stack
     * @throws NoSuchElementException if this stack is empty.
     */
     public Type pop() {
        return data.removeLast();
     }

    /**
     * Looks at the character at the top of this stack without removing it
     * from the stack.
     *
     * @return the character at the top of this stack
     * @throws NoSuchElementException if this stack is empty.
     */
     public Type peek() {
         return data.getLast();
     }



    /**
     * Returns the number of characters in this stack.
     *
     * @return the number of characters in this stack
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
