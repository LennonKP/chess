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
        int startX = move.getLinhaInicial();
        int startY = move.getColunaInicial();
        int endX = move.getLinhaFinal();
        int endY = move.getColunaFinal();

        Piece target = board.getPiece(endX, endY);
        if (target != null && target.getColor() == this.getColor()) {
            return false;
        }

        if (startX != endX && startY != endY) {
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
