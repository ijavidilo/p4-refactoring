package usantatecla.draughts.models;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    private static Pawn blackPawn() {
        return new Pawn(Color.BLACK);
    }

    private static Pawn whitePawn() {
        return new Pawn(Color.WHITE);
    }

    private static String boardWithoutPieces() {
        return  " 01234567\n" +
                " 0        0\n" +
                " 1        1\n" +
                " 2        2\n" +
                " 3        3\n" +
                " 4        4\n" +
                " 5        5\n" +
                " 6        6\n" +
                " 7        7\n" +
                " 01234567\n";
    }

    private static Coordinate coordinateOutsideBoardDimension() {
        return new Coordinate(-1, 0);
    }

    private static Pair<Coordinate, String> coordinateInsideBoardDimension() {
        String boardWithPiece =
                " 01234567\n" +
                " 0n       0\n" +
                " 1        1\n" +
                " 2        2\n" +
                " 3        3\n" +
                " 4        4\n" +
                " 5        5\n" +
                " 6        6\n" +
                " 7        7\n" +
                " 01234567\n";
        return new Pair<Coordinate, String>(new Coordinate(0, 0), boardWithPiece);
    }

    private static Pair<Coordinate, String> movementCoordinateInsideBoardDimension() {
        String boardNextMovementPiece =
                " 01234567\n" +
                " 0        0\n" +
                " 1 n      1\n" +
                " 2        2\n" +
                " 3        3\n" +
                " 4        4\n" +
                " 5        5\n" +
                " 6        6\n" +
                " 7        7\n" +
                " 01234567\n";
        return new Pair<Coordinate, String>(new Coordinate(1, 1), boardNextMovementPiece);
    }

    private Board board;

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void testGetPieceInsideBoardDimensionsThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        assertThat(board.getPiece(coordinateInsideBoardDimension().getKey()), is(equalTo(blackPawn())));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetPieceOutsideBoardDimensionsThenError() {
        board.getPiece(coordinateOutsideBoardDimension());
    }

    @Test
    public void testPutPieceInsideBoardDimensionsThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        assertThat(board.toString(), is(equalTo(coordinateInsideBoardDimension().getValue())));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPutPieceOutsideBoardDimensionsThenError() {
        board.put(coordinateOutsideBoardDimension(), blackPawn());
    }

    @Test
    public void testRemovePieceInsideBoardDimensionsThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        board.remove(coordinateInsideBoardDimension().getKey());
        assertThat(board.toString(), is(equalTo(boardWithoutPieces())));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemovePieceOutsideBoardDimensionsThenError() {
        board.remove(coordinateOutsideBoardDimension());
    }

    @Test(expected = AssertionError.class)
    public void testRemoveNullPieceThenError() {
        board.remove(null);
    }

    @Test
    public void testMovePieceInsideBoardDimensionsThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        board.move(coordinateInsideBoardDimension().getKey(), movementCoordinateInsideBoardDimension().getKey());
        assertThat(board.toString(), is(equalTo(movementCoordinateInsideBoardDimension().getValue())));
    }

    @Test(expected = NullPointerException.class)
    public void testMoveNullPieceThenNull() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        board.move(coordinateInsideBoardDimension().getKey(), null);
    }

    @Test
    public void testGetBetweenDiagonalPiecesOutOfTheBoardDimensions() {
        Coordinate originCoordinate = coordinateInsideBoardDimension().getKey();
        board.put(originCoordinate, blackPawn());

        Coordinate betweenCoordinate = movementCoordinateInsideBoardDimension().getKey();
        board.put(betweenCoordinate, whitePawn());

        Coordinate targetCoordinate = new Coordinate(2, 2);

        assertThat(board.getBetweenDiagonalPieces(originCoordinate, targetCoordinate).get(0), is(whitePawn()));
    }


    @Test
    public void testGetColorPieceThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        assertThat(board.getColor(coordinateInsideBoardDimension().getKey()), is(equalTo(Color.BLACK)));
    }

    @Test(expected = AssertionError.class)
    public void testGetColorOfNullPieceThenError() {
        board.getColor(null);
    }

    @Test
    public void testIsEmptyWhenThereIsAPieceInsideBoardDimensionsThenOk() {
        board.put(coordinateInsideBoardDimension().getKey(), blackPawn());
        assertThat(board.isEmpty(coordinateInsideBoardDimension().getKey()), is(Boolean.FALSE));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIsEmptyWhenThereIsAPieceOutsideBoardDimensionsThenError() {
        board.isEmpty(coordinateOutsideBoardDimension());
    }

    @Test(expected = AssertionError.class)
    public void testIsEmptyWhenNullPieceInsideBoardDimensionsThenError() {
        board.isEmpty(null);
    }

}