package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {
    private Game game;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.game.getValueState());
    }
}
