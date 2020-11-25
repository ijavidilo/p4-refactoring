package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MoveControllerTest {

    private GameBuilder gameBuilder;
    private MoveController moveController;

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
        this.moveController = new MoveController(game, new State());

        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = new Coordinate(6, 1);

        assertThat(moveController.move(origin, target), is(Error.NULL));
    }

    @Test
    public void testMovePawnWithNotEmptyTargetThenOk() {
        Game game = this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "   b    ",
                "  b     ").build();
        this.moveController = new MoveController(game, new State());

        Coordinate origin = new Coordinate(7, 2);
        Coordinate target = new Coordinate(6, 3);

        assertThat(moveController.move(origin, target), is(Error.NOT_EMPTY_TARGET));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMovePawnOutsideBoardLimitThenError() {
        Game game = this.gameBuilder.build();
        this.moveController = new MoveController(game, new State());
        moveController.move(new Coordinate(99, 99), new Coordinate(6, 3));
    }

    @Test(expected = AssertionError.class)
    public void testNullPawnAndMoveThenError() {
        Game game = this.gameBuilder.build();
        this.moveController = new MoveController(game, new State());

        Coordinate origin = new Coordinate(7, 0);

        assertThat(moveController.move(origin, null), is(nullValue()));
    }
}
