package usantatecla.draughts.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    private static Coordinate getFirstBlackPieceCoordinate() {
        return new Coordinate(2, 1);
    }

    private static Coordinate getFirstCorrectDiagonalMovementBlackPieceCoordinate() {
        return new Coordinate(3, 2);
    }

    private static Coordinate getFirstWhitePieceCoordinate() {
        return new Coordinate(5, 1);
    }

    @Test
    public void testOKCoordinateGetInstanceThenOk() {
        assertEquals(Coordinate.getInstance("21"), new Coordinate(1, 0));
    }

    @Test(expected = AssertionError.class)
    public void testNullCoordinateGetInstanceThenAssertionError() {
        Coordinate.getInstance(null);
    }

    @Test
    public void testWrongCoordinateGetInstanceThenNull() {
        assertThat(Coordinate.getInstance("ab"), is(nullValue()));
    }

    @Test
    public void testLimitCoordinateGetInstanceThenNull() {
        assertThat(Coordinate.getInstance("99"), is(nullValue()));
    }

    @Test
    public void testCorrectCreationCoordinateThenOk() {
        assertThat(getFirstBlackPieceCoordinate().getRow(), is(2));
        assertThat(getFirstBlackPieceCoordinate().getColumn(), is(1));
    }

    @Test(expected = AssertionError.class)
    public void testNullGetDirectionThenAssertionError() {
        getFirstBlackPieceCoordinate().getDirection(null);
    }

    @Test
    public void testCorrectCoordinateGetDirectionThenOk() {
        assertThat(getFirstBlackPieceCoordinate().getDirection(getFirstCorrectDiagonalMovementBlackPieceCoordinate()), is(Direction.NE));
    }

    @Test
    public void testBlackCoordinateThenIsTrue() {
        assertThat(getFirstBlackPieceCoordinate().isBlack(), is(Boolean.TRUE));
    }

    @Test
    public void testBlackCoordinateThenIsFalse() {
        assertThat(getFirstWhitePieceCoordinate().isBlack(), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectLimitCoordinateIsLastThenOk() {
        assertThat(new Coordinate(7, 0).isLast(), is(Boolean.TRUE));
    }

    @Test
    public void testErrorLimitCoordinateIsLastThenKO() {
        assertThat(new Coordinate(55, 0).isLast(), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectLimitCoordinateIsFirstThenOk() {
        assertThat(new Coordinate(0, 0).isFirst(), is(Boolean.TRUE));
    }

    @Test
    public void testErrorLimitCoordinateIsFirstThenKO() {
        assertThat(new Coordinate(55, 0).isFirst(), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectGetDimensionThenOk() {
        assertThat(new Coordinate(55, 0).getDimension(), is(equalTo(8)));
    }

    @Test
    public void testCorrectCoordinateIsOnDiagonalThenOk() {
        assertThat(getFirstBlackPieceCoordinate().isOnDiagonal(getFirstCorrectDiagonalMovementBlackPieceCoordinate()), is(Boolean.TRUE));
    }

    @Test
    public void testErrorCoordinateIsOnDiagonalThenKO() {
        assertThat(getFirstBlackPieceCoordinate().isOnDiagonal(Coordinate.getInstance("55")), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectDiagonalDistanceThenOk() {
        assertThat(getFirstBlackPieceCoordinate().getDiagonalDistance(getFirstCorrectDiagonalMovementBlackPieceCoordinate()), is(1));
    }

    @Test
    public void testIncorrectDiagonalDistanceThenKO() {
        assertThat(getFirstBlackPieceCoordinate().getDiagonalDistance(Coordinate.getInstance("87")), is(not(1)));
    }

    @Test(expected = AssertionError.class)
    public void testNotInDiagonalDiagonalDistanceThenKO() {
        getFirstBlackPieceCoordinate().getDiagonalDistance(Coordinate.getInstance("33"));
    }

    @Test
    public void testCorrectBetweenDiagonalCoordinateThenOk() {
        assertThat(new Coordinate(1, 1).getBetweenDiagonalCoordinate(new Coordinate(3, 3)), is(equalTo(new Coordinate(2, 2))));
    }

    @Test(expected = AssertionError.class)
    public void testIncorrectBetweenDiagonalCoordinateThenKO() {
        new Coordinate(1, 1).getBetweenDiagonalCoordinate(new Coordinate(5, 5));
    }

    @Test(expected = AssertionError.class)
    public void testNullBetweenDiagonalCoordinateThenNull() {
        new Coordinate(1, 1).getBetweenDiagonalCoordinate(null);
    }

    @Test
    public void testCorrectBetweenDiagonalCoordinatesListThenOK() {
        List<Coordinate> diagonalCoordinatesList = new ArrayList<>();
        diagonalCoordinatesList.add(new Coordinate(2, 2));
        diagonalCoordinatesList.add(new Coordinate(3, 3));
        diagonalCoordinatesList.add(new Coordinate(4, 4));

        assertThat(new Coordinate(1, 1).getBetweenDiagonalCoordinates(new Coordinate(5, 5)), is(diagonalCoordinatesList));
    }

    @Test
    public void testIncorrectBetweenDiagonalCoordinatesListThenKO() {
        List<Coordinate> diagonalCoordinatesList = new ArrayList<>();
        diagonalCoordinatesList.add(new Coordinate(4, 4));
        diagonalCoordinatesList.add(new Coordinate(3, 3));
        diagonalCoordinatesList.add(new Coordinate(2, 2));

        assertThat(new Coordinate(1, 1).getBetweenDiagonalCoordinates(new Coordinate(5, 5)), is(not(diagonalCoordinatesList)));
    }

    @Test
    public void testCorrectAllDiagonalCoordinatesMovesThenOK() {
        Coordinate coordinateCenter = new Coordinate(2, 2);

        List<Coordinate> diagonalCoordinatesList = new ArrayList<>();
        diagonalCoordinatesList.add(getNorthEastDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getSouthEastDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getSouthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getNorthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));

        assertThat(coordinateCenter.getDiagonalCoordinates(1), is(diagonalCoordinatesList));
    }

    private static Coordinate getNorthEastDiagonalCoordinateFromTheGivenCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() + 1);
    }

    private static Coordinate getSouthEastDiagonalCoordinateFromTheGivenCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() + 1);
    }

    private static Coordinate getSouthWestDiagonalCoordinateFromTheGivenCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() - 1);
    }

    private static Coordinate getNorthWestDiagonalCoordinateFromTheGivenCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() - 1);
    }

    @Test(expected = NullPointerException.class)
    public void testNullAllDiagonalCoordinatesMovesThenNull() {
        Coordinate coordinateCenter = new Coordinate(2, 2);

        List<Coordinate> diagonalCoordinatesList = new ArrayList<>();
        diagonalCoordinatesList.add(getNorthEastDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getSouthEastDiagonalCoordinateFromTheGivenCoordinate(null));
        diagonalCoordinatesList.add(getSouthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getNorthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));

        assertThat(coordinateCenter.getDiagonalCoordinates(1), is(diagonalCoordinatesList));
    }

    @Test(expected = AssertionError.class)
    public void testWrongAllDiagonalCoordinatesMovesThenKO() {
        Coordinate coordinateCenter = new Coordinate(2, 2);

        List<Coordinate> diagonalCoordinatesList = new ArrayList<>();
        diagonalCoordinatesList.add(getNorthEastDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getSouthEastDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getSouthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));
        diagonalCoordinatesList.add(getWrongNorthWestDiagonalCoordinateFromTheGivenCoordinate(coordinateCenter));

        assertThat(coordinateCenter.getDiagonalCoordinates(1), is(diagonalCoordinatesList));
    }

    private static Coordinate getWrongNorthWestDiagonalCoordinateFromTheGivenCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() - 1);
    }

}