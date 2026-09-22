// You should not have any more imports
import java.util.NoSuchElementException;

// Pick any 2 of the 3 problems, and complete for full credit (30 points each)
// You must get all cases correct to receive any credit
// for extra credit, you may complete the third problem for 15 points extra credit
// specify which one you want to count for extra credit, or it will be problem 1

public class Main {
    public static void main(String[] args) {
        String sep = "~".repeat(50);

        // how many solutions to print out regardless of whether they are correct or not
        // you probably want to leave this as 0...
        Tester.setNumSamples(0);

        // how many incorrect solutions to print out
        // anywhere 1 to 5 is pretty good
        Tester.setNumIncorrect(3);

        // Enables the progress bar
        Tester.enableProgressBar();

        // FIXME: Please specify which problems you want tested
        boolean testProblem1 = false;
        boolean testProblem2 = false;
        boolean testProblem3 = false;
        // FIXME: Please specify which problem you want to be counted as extra credit
        // If you make no selection then I will pick problem 1
        int extraCreditProblem = 0; // pick 1, 2, or 3

        System.out.println(sep);
        // Change the problems you are doing to true, and leave anything else as false
        if (testProblem1) { // problem 1
            Tester.problem1tests(2);
            System.out.println(sep);
        }
        if (testProblem2) { // problem 2
            Tester.problem2tests(2);
            System.out.println(sep);
        }
        if (testProblem3) { // problem 3
            Tester.problem3tests(5);
            System.out.println(sep);
        }

        if (!testProblem1 && !testProblem2 && !testProblem3) {
            System.out.println("You need to pick problems to test!");
        }
    }

    /**
     * Your goal is to de-duplicate the provided sorted ArrayList.
     * Your answer should contain no duplicates, but the all the original values, in sorted order.
     * <p>
     * You can safely assume that all inputs will be correctly sorted.
     * You do NOT need to sort the input.
     * <p>
     * n = size of array list <br>
     * Time : O(n) <br>
     * Space: O(n) (You can also do this in O(1) space, but it's harder) <br>
     * <p>
     * Examples: <br>
     * [2, 2, 2] -> [2] <br>
     * [1, 1, 2, 3, 3, 5, 5] -> [1, 2, 3, 5] <br>
     * [3, 3, 3, 3, 4, 7, 7, 7, 7, 7, 7] -> [3, 4, 7] <br>
     * [1, 2, 3] -> [1, 2, 3] <br>
     * @param sortedList the sorted input that contains duplicates
     * @param testCase the number of the current test case.
     *                 This should not be used in your solution;
     *                 only for debugging purposes.
     * @return a de-duplicated list
     */
    public static ArrayList<Integer> problem1(ArrayList<Integer> sortedList, int testCase) {
        return null;
    }

    /**
     * You are to implement round-robin process scheduling
     * using techniques taught in class.
     * <p>
     * The idea of round-robin process scheduling is that
     * all tasks are given equal priority,
     * and so partial completion of each process allows for
     * continuous progress on all tasks.
     * <p>
     * You are not actually given real processes to work with,
     * instead you are working with simulated processes that have
     * one method for you to use.
     * <br>
     * <code>
     * boolean finished = process.run();
     * </code>
     * <p>
     * n = number of provided processes <br>
     * s = maximum number of steps a process needs <br>
     * Time : O(ns) <br>
     * Space: O(n)
     * <p>
     * You should only use stacks and queues.
     * You may NOT use any other data structures.
     * <p>
     * Example:
     * Say you have processes [A, B, C, D]
     * where:
     * <ul>
     * <li> A needs to take 5 steps </li>
     * <li> B needs to take 3 steps </li>
     * <li> C needs to take 2 steps </li>
     * <li> D needs to take 6 steps </li>
     * </ul>
     * Then the processes should be processed in the order of: <br>
     * A B C D A B C D A B D A D A D D
     * <p>
     * <b>
     * The tester only checks that you have completed all processes.
     * I will check that it is round-robin during grading.
     * </b>
     * @param processes The list of processes you need to run to completion
     * @param testCase the number of the current test case.
     *                 This should not be used in your solution;
     *                 only for debugging purposes.
     */
    public static void problem2(ArrayList<Process> processes, int testCase) {
    }

    /**
     * In class, we described a method of evaluating mathematical expressions called Reverse Polish Notation.
     * Your goal is to evaluate the expression, only needing to implement multiplication ("*") and addition ("+").
     * <p>
     * If the string is not "*" or "+", then it is a number (int) which can be parsed using {@code Integer.parseInt(str)}.
     * <br>
     * You can safely assume all strings are either "*", "+", or a number. You should not need to check that a string is valid.
     * <br>
     * You can also safely assume that all expressions are correctly put into reverse polish notation.
     * You do not need to check the capacity when performing multiplication or addition.
     * <p>
     * n = size of input <br>
     * Time: O(n) <br>
     * Space: O(n) <br>
     * <p>
     * You should only use stacks, queues, and deques.
     * You may NOT use any other data structures.
     * <p>
     * Example: <br>
     * To evaluate the expression
     * [9, 12, +, 17, *, 262, +], you would perform the following sequence of operations:
     * <ol>
     * <li>9 + 12 = 21</li>
     * <li>21 * 17 = 357</li>
     * <li>357 + 262 = 619 </li>
     * </ol>
     * In other words, the expression can be written with standard infix notation as (9 + 12) * 17 + 262 and evaluated using normal order of operations.
     * More Examples: <br>
     * [128, 2, 30, +, +] -> 160 <br>
     * [126, 236, 3, *, +] -> 834 <br>
     * [1, 2, 2, +, 5, +, *, 78, *] -> 702 <br>
     * [4, 3, +, 24, 7, 14, +, +, 2, +, *] -> 329 <br>
     * @param input the sequence of numbers, operations ("*" or "+") to be executed.
     * @param testCase the number of the current test case.
     *                 This should not be used in your solution;
     *                 only for debugging purposes.
     * @return the value of the expression
     */
    public static int problem3(ArrayList<String> input, int testCase) {
        return -1;
    }
}
