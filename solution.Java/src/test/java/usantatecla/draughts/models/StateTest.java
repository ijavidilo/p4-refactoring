package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StateTest {

    private State state;

    @Before
    public void before() {
        state = new State();
    }

    @Test
    public void testResetStateValue() {
        state.reset();
        assertThat(state.getValueState(), is(equalTo(StateValue.INITIAL)));
    }

    @Test
    public void testAllStateOrderedValue() {
        assertThat(state.getValueState(), is(equalTo(StateValue.INITIAL)));

        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.IN_GAME)));

        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.FINAL)));

        state.next();
        assertThat(state.getValueState(), is(equalTo(StateValue.EXIT)));
    }

}
