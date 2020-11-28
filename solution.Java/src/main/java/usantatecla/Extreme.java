package usantatecla;

public abstract class Extreme {

    protected double value;

    public Extreme(double value) {
        this.value = value;
    }

    public abstract boolean isWithin(double value);

}
