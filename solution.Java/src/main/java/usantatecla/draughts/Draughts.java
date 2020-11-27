package usantatecla.draughts;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import java.util.HashMap;
import java.util.Map;

class Draughts {

    private Game game;
    private State state;
    private Map<StateValue, InteractorController> controllers;

    private Draughts(){
        this.game = new Game();
        this.state = new State();

        this.controllers = new HashMap<StateValue, InteractorController>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    private void play() {
        InteractorController controller;
        do {
            controller = this.controllers.get(this.state.getValueState());
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args){
        new Draughts().play();
    }
    
}