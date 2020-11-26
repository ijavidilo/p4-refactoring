package usantatecla.draughts.utils;

public class Coordinate {

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

    public int getDimensionValue() {
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
