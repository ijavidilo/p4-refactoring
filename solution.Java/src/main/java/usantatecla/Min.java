package usantatecla;

public class Min extends Extreme {

    public Min(double value) {
        super(value);
    }

    @Override
    public boolean include(double value) {
        return this.value < value;
    }

}
