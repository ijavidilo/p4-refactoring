package usantatecla;

public class Interval {

    private OpenMin openMin;
    private OpenMax openMax;

    public Interval(OpenMin openMin, OpenMax openMax) {
        assert openMin.value <= openMax.value;
        this.openMin = openMin;
        this.openMax = openMax;
    }

    public boolean include(double value) {
        return this.openMin.include(value) && this.openMax.include(value);
    }

    public boolean isIntersected(Interval interval) {
        assert interval != null;
        return (interval.openMax.include(this.openMin.getValue()) && interval.openMin.include(this.openMax.getValue())
                && this.openMin.include(interval.openMax.getValue()) && this.openMax.include(interval.openMin.getValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((openMax == null) ? 0 : openMax.hashCode());
        result = prime * result + ((openMin == null) ? 0 : openMin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Interval other = (Interval) obj;
        if (openMax == null) {
            if (other.openMax != null)
                return false;
        } else if (!openMax.equals(other.openMax))
            return false;
        if (openMin == null) {
            if (other.openMin != null)
                return false;
        } else if (!openMin.equals(other.openMin))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.openMin.toString() + ", " + openMax.toString();
    }

}