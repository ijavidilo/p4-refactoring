package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GameBuilder {

    public static final String[] INITIAL_STATE_BOARD = {
            " n n n n",
            "n n n n ",
            " n n n n",
            "        ",
            "        ",
            "b b b b ",
            " b b b b",
            "b b b b "
    };

    private static final Map<Character, Piece> TYPES_PIECES = new HashMap<Character, Piece>() {
        {
            put('b', new Pawn(Color.WHITE));
            put('B', new Draught(Color.WHITE));
            put('n', new Pawn(Color.BLACK));
            put('N', new Draught(Color.BLACK));
        }
    };

    private Color color;
    private List<String> lines;

    public GameBuilder() {
        this.lines = new ArrayList<>();
    }

    public GameBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public GameBuilder rows(String... rows){
        for (String string : rows) {
            assert isPieceAllowed(string);
            this.lines.add(string);
        }
        return this;
    }

    private boolean isPieceAllowed(String string) {
        return Pattern.matches("[bBnN ]{8}", string);
    }

    public Game build() {
        if (this.lines.size() == 0) {
            return new Game();
        }
        Board board = new Board();
        Game game = new Game(board);
        for (int i = 0; i < this.lines.size(); i++) {
            this.setRow(board, i, this.lines.get(i));
        }
        return game;
    }

    private void setRow(Board board, int row, String line) {
        for (int i = 0; i < line.length(); i++) {
            Piece piece = TYPES_PIECES.get(line.charAt(i));
            board.put(new Coordinate(row, i), piece);
        }
    }

}