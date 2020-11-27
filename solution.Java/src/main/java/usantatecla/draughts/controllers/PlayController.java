package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PlayController extends InteractorController {

	private static final String CANCEL_FORMAT = "-1";
	private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
	private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
	public static final int ZERO = 0;
	public static final int STDIN_SECOND_PART = 2;
	public static final char POINT_DELIMITER = '.';
	public static final int STDIN_FIRST_PART = 1;

	private CancelController cancelController;
	private MoveController moveController;
	private String stdin;

	public PlayController(Game game, State state) {
		super(game, state);
		this.cancelController = new CancelController(game, state);
		this.moveController = new MoveController(game, state);
	}

	@Override
	public void control() {
		Error error;
		do {
			error = null;
			this.stdin = new View().read(this.getColor());
			if (this.isCanceledFormat())
				this.cancel();
			else if (!this.isMoveFormat()) {
				error = Error.BAD_FORMAT;
				new View().writeError();
			} else {
				error = this.move(this.getCoordinates());
				new View().write(this);
				if (error == null && this.isBlocked())
					new View().writeLost();
			}
		} while (error != null);
	}

	public Error move(Coordinate... coordinates) {
		return this.moveController.move(coordinates);
	}

	public void cancel() {
		this.cancelController.cancel();
	}

	public Color getColor() {
		return this.game.getTurnColor();
	}

	public boolean isBlocked() {
		return this.game.isBlocked();
	}


	private boolean isCanceledFormat() {
		return stdin.equals(CANCEL_FORMAT);
	}

	private boolean isMoveFormat() {
		return Pattern.compile(MOVEMENT_FORMAT).matcher(stdin).find();
	}

	private Coordinate[] getCoordinates() {
		assert this.isMoveFormat();
		List<Coordinate> coordinateList = new ArrayList<Coordinate>();
		while (stdin.length() > ZERO) {
			coordinateList.add(Coordinate.getInstance(stdin.substring(0, 2)));
			stdin = stdin.substring(STDIN_SECOND_PART);
			if (stdin.length() > ZERO && stdin.charAt(ZERO) == POINT_DELIMITER)
				stdin = stdin.substring(STDIN_FIRST_PART);
		}
		Coordinate[] coordinates = new Coordinate[coordinateList.size()];
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i] = coordinateList.get(i);
		}
		return coordinates;
	}

}