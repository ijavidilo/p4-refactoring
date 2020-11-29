package usantatecla;

public class OpenMax extends Extreme {

    public OpenMax(double value) {
        super(value);
    }

    @Override
    public boolean include(double value) {
        return this.value > value;
    }

    @Override
    public String toString() {
        return this.value + ")";
    }

}
