package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DirectionTest {

    private static Coordinate getNorthEastCoordinate() {
        return new Coordinate(1, 1);
    }

    private static Coordinate getSouthEastCoordinate() {
        return new Coordinate(-1, 1);
    }

    private static Coordinate getSouthWestCoordinate() {
        return new Coordinate(-1, -1);
    }

    private static Coordinate getNorthWestCoordinate() {
        return new Coordinate(1, -1);
    }

    @Test
    public void testIsOnCorrectNorthEastDirection() {
        assertTrue(Direction.NE.isOnDirection(getNorthEastCoordinate()));
    }

    @Test
    public void testIsOnCorrectSouthEastDirection() {
        assertTrue(Direction.SE.isOnDirection(getSouthEastCoordinate()));
    }

    @Test
    public void testIsOnCorrectSouthWestDirection() {
        assertTrue(Direction.SW.isOnDirection(getSouthWestCoordinate()));
    }

    @Test
    public void testIsOnCorrectNorthWestDirection() {
        assertTrue(Direction.NW.isOnDirection(getNorthWestCoordinate()));
    }

    @Test
    public void testDistanceCoordinate() {
        assertThat(Direction.NW.getDistanceCoordinate(2), is(new Coordinate(2, -2)));
    }

}
