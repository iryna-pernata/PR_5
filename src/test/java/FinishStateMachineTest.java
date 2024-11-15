import org.example.FinishStateMachine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;



class FiniteStateMachineTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, THREE",
            "TEST, F",
            "TSET, ONE",
            "TEESTE, TWO",
            "TESabcTES, THREE",
            "abcTESTabc, F",
            "abcTES, THREE",
            "TTEST, F",
            "abcTEabc, S",
            "TTEESTT, ONE",
            "TETS, S"
    })
    void FinishStateMachineTest(String input, FinishStateMachine.State expectedState) {
        FinishStateMachine fsm = new FinishStateMachine();
        fsm.processString(input);
        assertEquals(expectedState, fsm.getCurrentState());
    }

    @ParameterizedTest
    @CsvSource({
            "TEST, true",
            "abcTESTabc, true",
            "TES, false",
            "TE, false",
            "T, false"
    })
    void testIsInFinalState(String input, boolean expectedResult) {
        FinishStateMachine fsm = new FinishStateMachine();
        fsm.processString(input);
        assertEquals(expectedResult, fsm.isInFinalState());
}
}
