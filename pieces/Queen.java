package pieces;

import game.Board;
import game.Color;
import game.Move;

public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(color, x, y);
        this.identifier = this.color == Color.BLACK ? 'q' : 'Q';
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startX = move.getLinhaInicial();
        int startY = move.getColunaInicial();
        int endX = move.getLinhaFinal();
        int endY = move.getColunaFinal();

        boolean isDiagonal = Math.abs(endX - startX) == Math.abs(endY - startY);
        boolean isStraight = startX == endX || startY == endY;

        if (!isDiagonal && !isStraight) {
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
