package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CancelControllerTest {

    private Game game;
    private State state;
    private CancelController cancelController;

    @Before
    public void before() {
        this.game = new GameBuilder().build();
        this.state = new State();
        this.cancelController = new CancelController(this.game, this.state);
    }

    @Test
    public void testCancelThenOk() {
        cancelController.cancel();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

}
