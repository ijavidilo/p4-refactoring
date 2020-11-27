package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.Piece;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.views.View;

public class StartController extends InteractorController {

	public static final String SPACE = " ";
	public static final String BLANK_SPACE = "";

	public StartController(Game game, State state) {
        super(game, state);
	}

	@Override
	public void control() {
		new View().write();
		this.write(this);
		this.state.next();
	}

	void write(InteractorController controller) {
		assert controller != null;
		final int DIMENSION = controller.getDimension();
		this.writeNumbersLine(DIMENSION);
		for (int i = 0; i < DIMENSION; i++)
			this.writePiecesRow(i, controller);
		this.writeNumbersLine(DIMENSION);
	}

	private void writeNumbersLine(final int DIMENSION) {
		new Console().write(SPACE);
		for (int i = 0; i < DIMENSION; i++)
			new Console().write((i + 1) + BLANK_SPACE);
		new Console().writeln();
	}

	private void writePiecesRow(final int row, InteractorController controller) {
		new Console().write((row + 1) + BLANK_SPACE);
		for (int j = 0; j < controller.getDimension(); j++) {
			Piece piece = controller.getPiece(new Coordinate(row, j));
			if (piece == null)
				new Console().write(SPACE);
			else
				new Console().write(piece.getCode());
		}
		new Console().writeln((row + 1) + BLANK_SPACE);
	}

}
