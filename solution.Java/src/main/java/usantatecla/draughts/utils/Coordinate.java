package usantatecla.draughts.utils;

public class Coordinate {

    protected int row;
    protected int column;

    protected Coordinate() {
    }

    protected Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
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
