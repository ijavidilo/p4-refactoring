package usantatecla;

public class Max extends Extreme {

    public Max(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(double value) {
        return this.value > value;
    }

}
