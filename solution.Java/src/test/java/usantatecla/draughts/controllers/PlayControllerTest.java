package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayControllerTest {

    private GameBuilder gameBuilder;
    private PlayController playController;

    @Before
    public void before() {
        this.gameBuilder = new GameBuilder();
    }

    @Test
    public void testMovePawnWithoutErrorThenOk() {
        Game game = this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "b       ").build();
        playController = new PlayController(game, new State());

        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = new Coordinate(6, 1);

        assertThat(playController.move(origin, target), is(Error.NULL));
    }

    @Test
    public void testCancelPlayControllerThenOk() {
        Game game = this.gameBuilder.build();
        State state = new State();
        playController = new PlayController(game, state);

        playController.cancel();

        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testGetColorPlayControllerThenOk() {
        Game game = this.gameBuilder.build();
        State state = new State();
        playController = new PlayController(game, state);

        assertThat(playController.getColor(), is(Color.WHITE));
    }

    @Test
    public void testIsBlockedPlayControllerThenOk() {
        Game game = this.gameBuilder.build();
        playController = new PlayController(game, new State());

        assertThat(playController.isBlocked(), is(Boolean.TRUE));
    }

    @Test(expected = AssertionError.class)
    public void testAcceptMethodNullObjectThenError() {
        Game game = this.gameBuilder.build();
        playController = new PlayController(game, new State());

        this.playController.accept(null);
    }

}
