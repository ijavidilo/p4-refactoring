package usantatecla;

public class Max extends Extreme {

    public Max(double value) {
        super(value);
    }

    @Override
    public boolean include(double value) {
        return this.value > value;
    }

}
