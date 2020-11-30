package usantatecla.tictactoe.controllers;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.models.GameBuilder;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.StateValue;

import static org.hamcrest.CoreMatchers.is;

public class StartControllerTest {

    public static final int NUMBER_PLAYERS = 2;

    private State state;
    private StartController startController;

    @BeforeEach
    public void before() {
        this.state = new State();
        this.startController = new StartController(new GameBuilder().build());
    }

    @Test
    public void testInGameStateThenOk() {
        this.state.next();
        MatcherAssert.assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testCorrectGetPawnPieceThenOk() {
        MatcherAssert.assertThat(this.startController.getMaxPlayers(), is(NUMBER_PLAYERS));
    }

}