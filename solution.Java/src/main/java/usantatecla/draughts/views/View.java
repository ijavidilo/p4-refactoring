package usantatecla.draughts.views;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Piece;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class View {

    public static final int ZERO = 0;
    public static final int STDIN_SECOND_PART = 2;
    public static final char POINT_DELIMITER = '.';
    public static final int STDIN_FIRST_PART = 1;
    public static final String SPACE = " ";
    public static final String BLANK_SPACE = "";
    private static final String TITTLE = "Draughts";
    private static final String MESSAGE = "¿Queréis jugar otra";
    private static final String COLOR_PARAM = "#color";
    private static final String[] COLOR_VALUES = {"blancas", "negras"};
    private static final String PROMPT = "Mueven las " + COLOR_PARAM + ": ";
    private static final String CANCEL_FORMAT = "-1";
    private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
    private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
    private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
    private String stdin;

    private YesNoDialog yesNoDialog;

    private Console console;

    public View() {
        this.console = new Console();
        this.yesNoDialog = new YesNoDialog();
    }

    public void write() {
        this.console.writeln(TITTLE);
    }

    public String read(Color color) {
        final String titleColor = PROMPT.replace(COLOR_PARAM, COLOR_VALUES[color.ordinal()]);
        return this.console.readString(titleColor);
    }

    private boolean isCanceledFormat() {
        return stdin.equals(CANCEL_FORMAT);
    }

    private boolean isMoveFormat() {
        return Pattern.compile(MOVEMENT_FORMAT).matcher(stdin).find();
    }

    public void writeError() {
        this.console.writeln(ERROR_MESSAGE);
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

    public void writeLost() {
        this.console.writeln(LOST_MESSAGE);
    }

    public boolean read() {
        return this.yesNoDialog.read(MESSAGE);
    }

    public void write(InteractorController controller) {
        assert controller != null;
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++)
            this.writePiecesRow(i, controller);
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(SPACE);
        for (int i = 0; i < DIMENSION; i++)
            this.console.write((i + 1) + BLANK_SPACE);
        this.console.writeln();
    }

    private void writePiecesRow(final int row, InteractorController controller) {
        this.console.write((row + 1) + BLANK_SPACE);
        for (int j = 0; j < controller.getDimension(); j++) {
            Piece piece = controller.getPiece(new Coordinate(row, j));
            if (piece == null)
                this.console.write(SPACE);
            else
                this.console.write(piece.getCode());
        }
        this.console.writeln((row + 1) + BLANK_SPACE);
    }

}
