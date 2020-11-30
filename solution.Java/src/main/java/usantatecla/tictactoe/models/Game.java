package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;

public class Game {

    private Board board;
    private Turn turn;
    private State state;

    public Game() {
        this.reset();
    }

    public void reset() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.state = new State();
    }

    public void setUsers(int users) {
        this.turn.setUsers(users);
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public boolean isUser() {
        return this.turn.isUser();
    }

    public Error put(Coordinate coordinate) {
        Error error = this.turn.put(coordinate);
        next(error);
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.turn.move(origin, target);
        next(error);
        return error;
    }

    public void next(Error error) {
        if (error.isNull() && !this.board.isTicTacToe(this.turn.getToken())) {
            this.turn.next();
        }
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getToken());
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getToken(coordinate);
    }

    public Token getToken() {
        return this.turn.getToken();
    }

    public int getMaxPlayers() {
        return Turn.NUMBER_PLAYERS;
    }

    public StateValue getValueState() {
        assert this.state != null;
        return this.state.getValueState();
    }

    public void next() {
        assert this.state != null;
        this.state.next();
    }
}
