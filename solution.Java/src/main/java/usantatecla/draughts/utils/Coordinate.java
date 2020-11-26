package usantatecla.draughts.utils;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 7;
    private static final int DIMENSION = UPPER_LIMIT + 1;

    protected int row;
    protected int column;
    protected int lowerLimit;
    protected int upperLimit;
    protected int dimension;

    protected Coordinate() {
    }

    protected Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        this.lowerLimit = LOWER_LIMIT;
        this.upperLimit = UPPER_LIMIT;
        this.dimension = DIMENSION;
    }

    protected Coordinate(int row, int column, int lowerLimit, int upperLimit, int dimension) {
        this(row, column);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.dimension = dimension;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }

    public int getUpperLimit() {
        return this.upperLimit;
    }

    public int getDimension() {
        return this.dimension;
    }

    public boolean isLast() {
        return this.row == this.upperLimit;
    }

    public boolean isFirst() {
        return this.row == this.lowerLimit;
    }

    public boolean isWithIn() {
        return this.lowerLimit <= this.row && this.row <= this.upperLimit && this.lowerLimit <= this.column
                && this.column <= this.upperLimit;
    }

    public boolean isBlack() {
        return (this.row + this.column) % 2 != 0;
    }

    public boolean isWhite() {
        return !this.isBlack();
    }

    public static Coordinate getInstance(String format) {
        assert format != null;
        try {
            int value = Integer.parseInt(format);
            int row = value / 10 - 1;
            int column = value % 10 - 1;
            Coordinate coordinate = new Coordinate(row, column);
            if (!coordinate.isWithIn())
                return null;
            return coordinate;
        } catch (Exception ex) {
            return null;
        }
    }

    private Coordinate substract(Coordinate coordinate) {
        return new Coordinate(this.row - coordinate.row, this.column - coordinate.column);
    }

    private Coordinate plus(Coordinate coordinate) {
        return new Coordinate(this.row + coordinate.row, this.column + coordinate.column);
    }

    public Direction getDirection(Coordinate coordinate) {
        assert coordinate != null;
        Coordinate substract = coordinate.substract(this);
        for (Direction direction : Direction.values())
            if (direction.isOnDirection(substract))
                return direction;
        return null;
    }

    public boolean isOnDiagonal(Coordinate coordinate) {
        return this.getDirection(coordinate) != null;
    }

    public int getDiagonalDistance(Coordinate coordinate) {
        assert this.isOnDiagonal(coordinate);
        return Math.abs(this.substract(coordinate).getRow());
    }

    public Coordinate getBetweenDiagonalCoordinate(Coordinate coordinate) {
        assert this.getDiagonalDistance(coordinate) == 2;
        final Direction direction = this.getDirection(coordinate);
        return this.plus(direction.getDistanceCoordinate(1));
    }

    public List<Coordinate> getBetweenDiagonalCoordinates(Coordinate coordinate) {
        assert this.isOnDiagonal(coordinate);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        final Direction direction = this.getDirection(coordinate);
        Coordinate cursor = this.plus(direction.getDistanceCoordinate(1));
        while (!cursor.equals(coordinate)) {
            coordinates.add(cursor);
            cursor = cursor.plus(direction.getDistanceCoordinate(1));
        }
        return coordinates;
    }

    public List<Coordinate> getDiagonalCoordinates(int level) {
        List<Coordinate> diagonalCoordinates = new ArrayList<Coordinate>();
        for (Direction direction : Direction.values()) {
            Coordinate diagonalCoordinate = this.plus(direction.getDistanceCoordinate(level));
            if (diagonalCoordinate != null && diagonalCoordinate.isWithIn())
                diagonalCoordinates.add(diagonalCoordinate);
        }
        return diagonalCoordinates;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object coordinateObject) {
        if (!(coordinateObject instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) coordinateObject;
        return this.column == coordinate.column && this.row == coordinate.row;
    }

}
