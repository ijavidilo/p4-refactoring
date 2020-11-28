package usantatecla;

public class IntervalBuilder {

    private OpenMin openMin;
    private OpenMax openMax;
    private boolean minConfigured;
    private boolean maxConfigured;

    IntervalBuilder() {
        this.minConfigured = Boolean.FALSE;
        this.maxConfigured = Boolean.FALSE;
    }

    private void minConfiguredToTrue() {
        this.minConfigured = Boolean.TRUE;
    }

    private void maxConfiguredToTrue() {
        this.maxConfigured = Boolean.TRUE;
    }

    public IntervalBuilder open(double value) {
        assert !this.minConfigured || !this.maxConfigured;

        if (!this.minConfigured) {
            this.openMin = new OpenMin(value);
            minConfiguredToTrue();
        } else if (!this.maxConfigured) {
            this.openMax = new OpenMax(value);
            maxConfiguredToTrue();
        }
        return this;
    }

    public IntervalBuilder closed(double value) {
        assert !this.minConfigured || !this.maxConfigured;

        if (!this.minConfigured) {
            this.openMin = new ClosedMin(value);
            minConfiguredToTrue();
        } else if (!this.maxConfigured) {
            this.openMax = new ClosedMax(value);
            maxConfiguredToTrue();
        }
        return this;
    }

    public Interval build() {
        assert this.minConfigured && this.maxConfigured;
        return new Interval(this.openMin, this.openMax);
    }

}
