// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Process {
    private int numSteps;
    private final ArrayList<Process> dependencies;

    /**
     * This is for my use only. You should not be constructing any processes!
     */
    public Process(int numSteps, ArrayList<Process> dependencies) {
        this.numSteps = numSteps;
        this.dependencies = dependencies;
    }

    public boolean run() {
        if (numSteps <= 0) {
            throw new RuntimeException("You cannot run zombie processes!!" +
                    " This is a logic error in your program that you must fix," +
                    " and you are not allowed to Try/Catch this exception!");
        }
        for (int i = dependencies.size() - 1; i >= 0; i--) {
            Process dep = dependencies.get(i);
            if (dep.numSteps > 0) {
                return false;
            }
        }
        numSteps -= 1;

        return numSteps == 0;
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
