package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.StateValue;

public class State {

    private StateValue stateValue;

    public State() {
        this.stateValue = null;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

}
