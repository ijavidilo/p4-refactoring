package usantatecla;

public class Min extends Extreme {

    public Min(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(double value) {
        return this.value < value;
    }

}
