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
        int startX = move.getLinhaInicial();
        int startY = move.getColunaInicial();
        int endX = move.getLinhaFinal();
        int endY = move.getColunaFinal();

        if (Math.abs(endX - startX) != Math.abs(endY - startY)) {
            return false;
        }

        int dx = Integer.signum(endX - startX);
        int dy = Integer.signum(endY - startY);

        int currentX = startX + dx;
        int currentY = startY + dy;

        while (currentX != endX || currentY != endY) {
            if (board.getPiece(currentX, currentY) != null) {
                return false;
            }
            currentX += dx;
            currentY += dy;
        }

        return true;
    }

}
