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
        int startX = move.getLinhaInicial();
        int startY = move.getColunaInicial();
        int endX = move.getLinhaFinal();
        int endY = move.getColunaFinal();

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        return dx <= 1 && dy <= 1;
    }

}
