package pieces;

import game.Board;
import game.Color;
import game.Move;

public class Bishop extends Piece {

    public Bishop(Color color, int x, int y) {
        super(color, x, y);
        this.identifier = this.color == Color.BLACK ? 'b' : 'B';
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidMove'");
    }

}
