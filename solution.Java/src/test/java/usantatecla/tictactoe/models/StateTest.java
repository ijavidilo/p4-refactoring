package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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

}
