package usantatecla;

public class OpenMin extends Extreme {

    public OpenMin(double value) {
        super(value);
    }

    @Override
    public boolean include(double value) {
        return this.value < value;
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }

}
