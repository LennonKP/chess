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

    public abstract boolean isValidMove(Move move, Board board);

}
