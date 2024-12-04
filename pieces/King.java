package pieces;

import game.Board;
import game.Color;
import game.Move;

public class King extends Piece {

    public King(Color color, int x, int y) {
        super(color, x, y);
        this.identifier = this.color == Color.BLACK ? 'k' : 'K';
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidMove'");
    }

}
