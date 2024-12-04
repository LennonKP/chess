package pieces;

import game.Board;
import game.Color;
import game.Move;

public class Rook extends Piece {

    public Rook(Color color, int x, int y) {
        super(color, x, y);
        this.identifier = this.color == Color.BLACK ? 't' : 'T';
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidMove'");
    }

}
