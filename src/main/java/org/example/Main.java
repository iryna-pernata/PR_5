package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FinishStateMachine fsm = new FinishStateMachine();

        String input1 = "abcTESTabc";
        fsm.run(input1);
        System.out.println("Рядок \"" + input1 + "\" -> " + fsm.getCurrentState());

        fsm.reset();

        String input2 = "abcTES";
        fsm.run(input2);
        System.out.println("Рядок \"" + input2 + "\" -> " + fsm.getCurrentState());

    }
}