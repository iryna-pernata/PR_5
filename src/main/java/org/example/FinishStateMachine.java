package org.example;

public class FinishStateMachine {
    public enum State {
        S,
        ONE,
        TWO,
        THREE,
        F
    }

    private State currentState;

    public FinishStateMachine() {
        this.currentState = State.S;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void process(char input) {
        switch (currentState) {
            case S:
                if (input == 'T') currentState = State.ONE;
                else {
                    currentState = State.S;
                }
                break;
            case ONE:
                if (input == 'E') currentState = State.TWO;
             else if (input == 'T') currentState = State.ONE;
                else currentState = State.S;
                break;
            case TWO:
                if (input == 'S') currentState = State.THREE;
               else if (input == 'T') currentState = State.ONE;
                else currentState = State.S;
                break;
            case THREE:
            if (input == 'T') currentState = State.F;
                else currentState = State.S;
                break;
            case F:
                break;
        }
    }

    public boolean isInFinalState() {
        return currentState == State.F;
    }

    public void reset() {
        currentState = State.S;
    }

    public void processString(String input) {
        for (char c : input.toCharArray()) {
            process(c);
        }
    }
}

