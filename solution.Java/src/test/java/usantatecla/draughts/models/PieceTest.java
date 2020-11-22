package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PieceTest {

    private static Pawn whitePawn() {
        return new Pawn(Color.WHITE);
    }

    private static Pawn blackPawn() {
        return new Pawn(Color.BLACK);
    }

    @Test
    public void testPawnIsLimit() {
        List<Pair<Pawn, Coordinate>> piecesList = Arrays.asList(
                new Pair(whitePawn(), new Coordinate(0, 0)),
                new Pair(blackPawn(), new Coordinate(7, 7))
        );

        for (Pair<Pawn, Coordinate> piece : piecesList) {
            assertThat(piece.getValue0().isLimit(piece.getValue1()), is(Boolean.TRUE));
        }
    }

    @Test(expected = AssertionError.class)
    public void testAdvancedPawnWithNullOrigin() {
        whitePawn().isAdvanced(null, new Coordinate(7, 2));
    }

    @Test(expected = AssertionError.class)
    public void testAdvancedPawnToNullTarget() {
        whitePawn().isAdvanced(new Coordinate(8, 1), null);
    }

    @Test
    public void testPawnIsCorrectAdvanced() {
        List<Triplet<Pawn, Coordinate, Coordinate>> piecesList = Arrays.asList(
                new Triplet(whitePawn(), new Coordinate(6, 1), new Coordinate(5, 2)),
                new Triplet(whitePawn(), new Coordinate(6, 3), new Coordinate(5, 2)),
                new Triplet(blackPawn(), new Coordinate(3, 2), new Coordinate(4, 1)),
                new Triplet(blackPawn(), new Coordinate(3, 2), new Coordinate(4, 3))
        );

        for (Triplet<Pawn, Coordinate, Coordinate> piece : piecesList) {
            assertThat(movement(piece), is(Boolean.TRUE));
        }
    }

    @Test
    public void testPawnIsIncorrectAdvanced() {
        List<Triplet<Pawn, Coordinate, Coordinate>> piecesList = Arrays.asList(
                new Triplet(whitePawn(), new Coordinate(6, 1), new Coordinate(7, 1)),
                new Triplet(whitePawn(), new Coordinate(6, 1), new Coordinate(7, 2)),
                new Triplet(blackPawn(), new Coordinate(2, 1), new Coordinate(2, 3)),
                new Triplet(blackPawn(), new Coordinate(2, 1), new Coordinate(1, 2))
        );

        for (Triplet<Pawn, Coordinate, Coordinate> piece : piecesList) {
            assertThat(movement(piece), is(Boolean.FALSE));
        }
    }

    private boolean movement(Triplet<Pawn, Coordinate, Coordinate> piece) {
        return piece.getValue0().isAdvanced(piece.getValue1(), piece.getValue2());
    }

    @Test
    public void testPawnIsCorrectColor() {
        assertThat(whitePawn().getColor(), is(Color.WHITE));
    }

}
