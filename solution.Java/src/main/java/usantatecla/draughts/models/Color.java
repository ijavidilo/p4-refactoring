package usantatecla.draughts.models;

public enum Color {
    WHITE,
    BLACK,
    NULL;

    private final int[] LIMITS = new int[]{5, 2};

    boolean isInitialRow(final int row) {
        switch (this) {
            case WHITE:
                return row >= LIMITS[this.ordinal()];
            case BLACK:
                return row <= LIMITS[this.ordinal()];
            case NULL:
            default:
                return false;
        }
    }

    static Color getInitialColor(final Coordinate coordinate) {
        if (coordinate.isBlack())
            for (Color color : Color.values())
                if (color.isInitialRow(coordinate.getRow()))
                    return color;
        return Color.NULL;
    }

    boolean isNull() {
        return this.equals(Color.NULL);
    }

    boolean isNotNull() {
        return !(this.isNull());
    }

}