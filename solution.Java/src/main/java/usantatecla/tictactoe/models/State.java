package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.StateValue;

public class State {

    private StateValue stateValue;

    public State() {
        init();
    }

    private void init() {
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
    }


}
