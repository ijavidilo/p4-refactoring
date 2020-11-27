package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.views.View;

public class ResumeController extends InteractorController {

	public ResumeController(Game game, State state) {
        super(game, state);
	}

	public void next() {
        this.state.next();
	}

	public void reset() {
		this.state.reset();
		this.game.reset();
	}

    @Override
	public void accept(InteractorControllersVisitor controllersVisitor) {
		assert controllersVisitor != null;
		controllersVisitor.visit(this);
	}

	@Override
	public void control() {
		if (new View().read()) {
			this.state.reset();
			this.game.reset();
		} else {
			this.state.next();
		}
	}

}
