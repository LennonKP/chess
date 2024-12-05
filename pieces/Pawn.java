package pieces;

import game.Board;
import game.Color;
import game.Move;

public class Pawn extends Piece {
    private boolean alreadyMoved;

    public Pawn(Color color, int x, int y) {
        super(color, x, y);
        this.identifier = this.color == Color.BLACK ? 'p' : 'P';
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        Piece target = board.getPiece(move.getLinhaFinal(), move.getColunaFinal());
        int targetX = move.getLinhaFinal(), targetY = move.getColunaFinal();
        int direction = this.color == Color.WHITE ? -1 : 1;
        int limit = this.alreadyMoved ? 1 : 2;
        boolean isAttacking = target != null && target.getColor() != this.color;

        if (isAttacking) {
            return targetX == this.x + direction && Math.abs(targetY - this.y) == 1;
        }

        if (targetY != this.y) {
            return false;
        }

        if (targetX == this.x + direction || (!this.alreadyMoved && targetX == this.x + 2 * direction)) {
            if (limit == 2 && board.getPiece(this.x + direction, this.y) != null) {
                return false;
            }
            this.alreadyMoved = true;
            return true;
        }

        return false;
    }

}
