package pieces;

import game.Board;
import game.Color;
import game.Move;

public abstract class Piece {
    protected int x, y;

    protected Color color;
    protected char identifier;

    public Piece(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public char getIdentifier() {
        return this.identifier;
    };

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract boolean isValidMove(Move move, Board board);

    public void move(Move move, Board board) throws Exception {
        if (!this.isValidMove(move, board)) {
            throw new Exception("Not a valid move");
        }

        this.setX(move.getLinhaFinal());
        this.setY(move.getColunaFinal());
    }

}
