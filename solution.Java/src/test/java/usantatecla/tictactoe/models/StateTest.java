package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.StateValue;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StateTest {

    private State state;

    @BeforeEach
    public void before() {
        state = new State();
    }

    @Test
    public void testNullConstructorStateThenOk() {
        assertThat(state.getValueState(), is(nullValue()));
    }

    @Test
    public void testInitialConstructorStateThenOk() {
        assertThat(state.getValueState(), is(equalTo(StateValue.INITIAL)));
    }

    @Test
    public void testNextStateOrderedValueThenOk() {
        state.next();
        assertThat(state.getValueState(), is(nullValue()));
    }

}
