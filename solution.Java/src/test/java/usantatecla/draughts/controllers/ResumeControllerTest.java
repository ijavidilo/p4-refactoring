package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResumeControllerTest {

    private static final int MAX_STATES_VALUES_LENGTH = 4;

    private State state;
    private ResumeController resumeController;

    private StateValue getGameWithFinalStateValue() {
        this.resumeController.next();
        this.resumeController.next();
        return this.state.getValueState();
    }

    @Before
    public void before() {
        this.state = new State();
        this.resumeController = new ResumeController(new GameBuilder().build(), state);
    }

    @Test
    public void testNextStateThenOk() {
        assertThat(getGameWithFinalStateValue(), is(StateValue.FINAL));
    }

    @Test(expected = AssertionError.class)
    public void testLimitNextStateThenError() {
        for (int i = 0; i < MAX_STATES_VALUES_LENGTH; i++) {
            this.resumeController.next();
        }
    }

    @Test
    public void testResetGameThenOk() {
        getGameWithFinalStateValue();
        this.resumeController.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test(expected = AssertionError.class)
    public void testAcceptMethodNullObjectThenError() {
        this.resumeController.accept(null);
    }

}
