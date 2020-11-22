package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameBuilderTest {

    private static Coordinate coordinateInsideBoardDimension() {
        return new Coordinate(7, 0);
    }

    private static Coordinate coordinateNextMoveInsideBoardDimension() {
        return new Coordinate(6, 1);
    }

    private GameBuilder gameBuilder;

    @Before
    public void before() {
        this.gameBuilder = new GameBuilder();
    }

    @Test()
    public void testInitialStateGameBuilderThenOk() {
        this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ").build();
    }

    @Test
    public void testResetGameThenOk() {
        Game gameFinished = this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "B       ").build();

        gameFinished.reset();
        assertThat(new Game(), is(gameFinished));
    }

    @Test
    public void testLocatePieceColorsInsideGameBuilderThenOk() {
        Game game = this.gameBuilder.rows(
                "n       ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "b       ").build();

        assertThat(game.getColor(new Coordinate(0, 0)), is(Color.BLACK));
        assertThat(game.getColor(new Coordinate(7, 0)), is(Color.WHITE));
        assertThat(game.getColor(new Coordinate(0, 1)), is(nullValue()));
    }

    @Test
    public void testCorrectMovePieceInsideGameBuilderThenOk() {
        Game game = this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "b       ").build();

        game.move(coordinateInsideBoardDimension(), coordinateNextMoveInsideBoardDimension());
        assertThat(game.getPiece(coordinateNextMoveInsideBoardDimension()), is(notNullValue()));
    }

    @Test
    public void testEatBlackPieceInsideGameBuilderThenOk() {
        Game game = this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                " n      ",
                "b       ").build();

        Coordinate pieceToEat = new Coordinate(6, 2);
        game.move(coordinateInsideBoardDimension(), coordinateNextMoveInsideBoardDimension());
        assertThat(game.getPiece(pieceToEat), is(nullValue()));
    }

    @Test(expected = AssertionError.class)
    public void testIncorrectPieceGameBuilderThenError() {
        this.gameBuilder.rows(
                "        ",
                "        ",
                "        ",
                "        ",
                "   x    ",
                "        ",
                "        ",
                "        ").build();
    }

    @Test(expected = AssertionError.class)
    public void testIncorrectLengthGameBuilderThenError() {
        this.gameBuilder.rows(
                "               ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ").build();
    }

}
