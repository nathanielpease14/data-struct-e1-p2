// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.HashSet;
import java.util.Random;

public class Tester {
    private static int numSamples = 0;
    private static int numIncorrect = 0;
    private static boolean progressBar = false;

    /**
     * @param numSamples the number of test cases to print out from beginning
     */
    public static void setNumSamples(int numSamples) {
        Tester.numSamples = numSamples;
    }

    /**
     * @param numIncorrect number of incorrect test cases to print
     */
    public static void setNumIncorrect(int numIncorrect) {
        Tester.numIncorrect = numIncorrect;
    }

    /**
     * Enables the progress bar
     */
    public static void enableProgressBar() {
        Tester.progressBar = true;
    }

    public static void problem1tests(int seed) {
        Random rand = new Random(seed);
        ArrayList<ArrayList<Integer>> inputs = problem1inputs(rand);
        int TOTAL_PROBLEMS = inputs.size();
        int incorrect = 0;
        int problems = 0;
        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            ArrayList<Integer> input = inputs.get(i);
            ArrayList<Integer> studentAnswer = Main.problem1(new ArrayList<>(input), i);
            String incorrectReason = problem1reasonIncorrect(input, studentAnswer);
            boolean isCorrect = incorrectReason == null;
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 1 Test Case " + i);
                System.out.println("Input: " + ArrayListToString(input));
                System.out.println("Your Answer: " + ArrayListToString(studentAnswer));
                System.out.println("Reason Incorrect: " + incorrectReason);
                System.out.println();
            }
            incorrect += isCorrect ? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 1: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }

        System.out.printf("Problem 1: %d / %d Correct\n", problems - incorrect, TOTAL_PROBLEMS);
    }

    private static String problem1reasonIncorrect(ArrayList<Integer> input, ArrayList<Integer> studentAnswer) {
        if (studentAnswer == null) {
            return "Have not completed the problem";
        }
        if (!isSorted(input)) {
            throw new AssertionError("Invalid input! This shouldn't happen");
        }
        if (!isSorted(studentAnswer)) {
            return "Somehow your answer became unsorted";
        }
        HashSet<Integer> inputValues = new HashSet<>(studentAnswer.size());
        for (Integer v: input) {
            inputValues.add(v);
        }
        HashSet<Integer> studentValues = new HashSet<>(inputValues.size());
        for (Integer v: studentAnswer) {
            studentValues.add(v);
            if (!inputValues.contains(v)) {
                return String.format("Strange Value %d not found in input", v);
            }
        }
        // studentValues must be a subset of inputValues after previous loop
        if (studentValues.size() < inputValues.size()) {
            for (Integer v: inputValues) {
                if (!studentValues.contains(v)) {
                    return String.format("You are missing the value %d!", v);
                }
            }
            return "Not possible";
        } else if (studentValues.size() > inputValues.size()) {
            return "Not possible";
        }

        if (studentValues.size() != studentAnswer.size()) {
            return "Your answer contains duplicates!";
        }

        return null;
    }

    private static<T> String ArrayListToString(ArrayList<T> input) {
        if (input == null) {
            return "null";
        }
        int length = input.size();
        if (length > 100) {
            return "Large Test Case";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(input.get(i).toString());
        }
        result.append("]");

        return result.toString();
    }

    private static ArrayList<ArrayList<Integer>> problem1inputs(Random rand) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // provided test cases:
        result.add(new ArrayList<>(new Integer[]{2, 2, 2}));
        result.add(new ArrayList<>(new Integer[]{1, 1, 2, 3, 3, 5, 5}));
        result.add(new ArrayList<>(new Integer[]{3, 3, 3, 3, 4, 7, 7, 7, 7, 7, 7}));

        int SMALL_BATCH_CASES = 50;
        // random test cases:
        int RAND_START = 3;
        for (int i = 0; i < SMALL_BATCH_CASES; i++) {
            int size = RAND_START + i;
            result.add(problem1rand(size, rand));
        }

        // singular test cases:
        int SINGULAR_START = 50;
        int SINGULAR_STEP = 1000;
        for (int i = 0; i < SMALL_BATCH_CASES; i++) {
            int size = SINGULAR_START + SINGULAR_STEP * i;
            result.add(problem1singular(size, rand));
        }

        // double test cases:
        int DOUBLE_START = 30;
        int DOUBLE_STEP = 10;
        for (int i = 0; i < SMALL_BATCH_CASES; i++) {
            int size = DOUBLE_START + DOUBLE_STEP * i;
            result.add(problem1double(size, rand));
        }

        int[] large_sizes = {500_000, 1_000_000, 5_000_000, 10_000_000};
        for (int size: large_sizes) {
            result.add(problem1rand(size, rand));
            result.add(problem1singular(size, rand));
            result.add(problem1double(size, rand));
        }

        return result;
    }


    private static boolean isSorted(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int first = list.get(i);
            int second = list.get(i + 1);
            if (first > second) {
                return false;
            }
        }
        return true;
    }


    private static ArrayList<Integer> problem1double(int size, Random rand) {
        if ((size & 1) == 1) {
            throw new AssertionError("Double needs an even size");
        }
        int half = size >> 1;
        ArrayList<Integer> result = new ArrayList<>(size);

        int currentValue = rand.nextInt(100);
        for (int i = 0; i < half; i++) {
            result.add(currentValue);
            result.add(currentValue);
            currentValue += rand.nextInt(1, 4);
        }
        return result;
    }

    private static ArrayList<Integer> problem1singular(int size, Random rand) {
        ArrayList<Integer> result = new ArrayList<>(size);

        int value = rand.nextInt(100);
        for (int i = 0; i < size; i++) {
            result.add(value);
        }

        return result;
    }

    private static ArrayList<Integer> problem1rand(int size, Random rand) {
        ArrayList<Integer> result = new ArrayList<>(size);

        int currentValue = rand.nextInt(100);
        result.add(currentValue);
        for (int i = 1; i < size; i++) {
            if (rand.nextBoolean()) {
                currentValue += rand.nextInt(1, 4);
            }
            result.add(currentValue);
        }

        return result;
    }

    public static void problem2tests(int seed) {
        Random rand = new Random(seed);
        ArrayList<ArrayList<Process>> inputs = problem2inputs(rand);
        int TOTAL_PROBLEMS = inputs.size();
        int problems = 0;
        int incorrect = 0;

        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            ArrayList<Process> input = inputs.get(i);
            Process superProcess = new Process(1, input);
            Main.problem2(new ArrayList<>(input), i);
            boolean isCorrect = superProcess.run();
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 2 Test Case " + i);
                System.out.println("Not all processes finished! Use Debugger for more info");
                System.out.println();
            }
            incorrect += isCorrect? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 2: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }
        System.out.printf("Problem 2: %d / %d Correct\n", TOTAL_PROBLEMS - incorrect, TOTAL_PROBLEMS);
    }

    private static ArrayList<ArrayList<Process>> problem2inputs(Random rand) {

        int NUM_PROBLEMS = 100;
        int MIN_LENGTH = 3;
        ArrayList<ArrayList<Process>> result = new ArrayList<>(NUM_PROBLEMS);
        for (int i = 0; i < NUM_PROBLEMS; i++) {
            result.add(problem2input(rand, MIN_LENGTH + i, i));
        }

        int NUM_LARGE = 10;
        int STEP_LARGE = 20000;
        for (int i = 1; i <= NUM_LARGE; i++) {
            result.add(problem2input(rand, MIN_LENGTH + STEP_LARGE * i, 0));
        }

        return result;
    }

    private static ArrayList<Process> problem2input(Random rand, int processes, int dependencyPercentChance) {
        int MAX_STEPS = 10;
        ArrayList<Process> input = new ArrayList<>(processes);
        for (int j = 0; j < processes; j++) {
            ArrayList<Process> dependencies = new ArrayList<>();
            if (dependencyPercentChance > 0) {
                for (Process p : input) {
                    if (rand.nextInt(100) <= dependencyPercentChance) {
                        dependencies.add(p);
                    }
                }
            }

            int numSteps = rand.nextInt(1, MAX_STEPS);
            Process process = new Process(numSteps, dependencies);
            input.add(process);
        }
        // shuffle
        for (int j = input.size() - 1; j > 0; j--) {
            int randIndex = rand.nextInt(j + 1);
            Process temp = input.get(j);
            input.set(j, input.get(randIndex));
            input.set(randIndex, temp);
        }

        return input;
    }

    public static void problem3tests(int seed) {
        Random rand = new Random(seed);
        ArrayList<Problem3Problem> inputs = problem3inputs(rand);
        int TOTAL_PROBLEMS = inputs.size();
        int problems = 0;
        int incorrect = 0;
        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            Problem3Problem prob = inputs.get(i);
            ArrayList<String> input = prob.input;
            int answer = prob.answer;
            int studentAnswer = Main.problem3(input, i);
            boolean isCorrect = answer == studentAnswer;
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 3 Test Case " + i);
                System.out.println("Input: " + ArrayListToString(input));
                System.out.println("Correct Answer: " + answer);
                System.out.println("Your Answer: " + studentAnswer);
                System.out.println();
            }
            incorrect += studentAnswer == answer ? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 3: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }
        System.out.printf("Problem 3: %d / %d Correct\n", problems - incorrect, problems);
    }

    private static final class Problem3Problem {
        private final ArrayList<String> input;
        private final int answer;

        Problem3Problem(ArrayList<String> input, int answer) {
            this.input = input;
            this.answer = answer;
        }
    }

    private static ArrayList<Problem3Problem> problem3inputs(Random rand) {
        ArrayList<Problem3Problem> problems = new ArrayList<>();
        int NUM_PROBLEMS = 100;
        int ANSWER_MIN = 100;
        int ANSWER_MAX = 999;
        int SPLITS_MIN = 3;
        int SPLITS_STEP = 5;
        for (int i = 0; i < NUM_PROBLEMS; i++) {
            int answer = rand.nextInt(ANSWER_MIN, ANSWER_MAX + 1);
            int splits = rand.nextInt(SPLITS_MIN, SPLITS_MIN + 1 + i * SPLITS_STEP);
            ArrayList<String> input = new ArrayList<>();
            problem3appendInput(input, answer, splits, rand);
            problems.add(new Problem3Problem(input, answer));
        }
        return problems;
    }

    private static void problem3appendInput(ArrayList<String> input, int answer, int integers, Random rand) {
        if (integers <= 1) {
            input.add(Integer.toString(answer));
            return;
        }

        String op;
        int op1, op2;
        if (rand.nextBoolean()) {
            op = "*";
            int factor = randomFactor(answer, rand);
            op1 = factor;
            op2 = answer / factor;
        } else {
            op = "+";
            op1 = rand.nextInt(answer + 1);
            op2 = answer - op1;
        }

        int split1 = rand.nextInt(1, integers);
        int split2 = integers - split1;
        problem3appendInput(input, op1, split1, rand);
        problem3appendInput(input, op2, split2, rand);
        input.add(op);
    }

    private static int randomFactor(int input, Random rand) {
        if (input == 0) {
            return rand.nextInt(2, 20);
        }
        ArrayList<Integer> smallFactors = new ArrayList<>();
        if (input % 2 == 0) {
            smallFactors.add(2);
        }
        for (int i = 3; i * i < input; i += 2) {
            if (input % i == 0) {
                smallFactors.add(i);
            }
        }
        int answer;
        if (smallFactors.size() > 0) {
            answer = smallFactors.get(rand.nextInt(smallFactors.size()));
        } else {
            answer = 1;
        }
        if (rand.nextBoolean()) {
            answer = input / answer; // large factor
        }
        return answer;
    }

}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
