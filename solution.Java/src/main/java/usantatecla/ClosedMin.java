package usantatecla;

public class ClosedMin extends Min {

    public ClosedMin(double value) {
        super(value);
    }

    @Override
    public boolean include(double value) {
        return super.include(value) || this.value == value;
    }

    @Override
    public String toString() {
        return "[" + this.value;
    }

}
