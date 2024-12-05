package game;

import java.util.ArrayList;
import java.util.List;

import pieces.Pawn;
import pieces.Piece;

public class Board {
    private List<Piece> capturedPieces;
    private Color currentPlayer;
    private boolean gameOver;
    private pieces.Piece[][] board;

    public boolean isGameOver() {
        return gameOver;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public Piece getPiece(int row, int column) {
        return this.board[row][column];
    }

    public Board() {
        this.currentPlayer = Color.WHITE;
        this.gameOver = false;
        this.board = new pieces.Piece[8][8];
        this.capturedPieces = new ArrayList<Piece>();
        this.initializePieces();
        this.print();
    }

    private void changeTurn() {
        this.currentPlayer = this.currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public void movePiece(Piece piece, Move move) {

    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            var pieces = this.board[i];
            System.out.print((i + 1) + " -> |");
            for (Piece piece : pieces) {
                if (piece == null) {
                    System.out.print(" . |");
                    continue;
                }
                System.out.print(" " + piece.getIdentifier() + " |");
            }
            System.out.println();
        }
        System.out.println("     --------------------------------");
        System.out.println("       A   B   C   D   E   F   G   H");
    }

    private void initializePieces() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.BLACK, 1, i);
            board[6][i] = new Pawn(Color.WHITE, 6, i);
        }

        board[0][0] = new pieces.Rook(Color.BLACK, 0, 0);
        board[0][7] = new pieces.Rook(Color.BLACK, 0, 7);
        board[7][0] = new pieces.Rook(Color.WHITE, 7, 0);
        board[7][7] = new pieces.Rook(Color.WHITE, 7, 7);

        board[0][1] = new pieces.Knight(Color.BLACK, 0, 1);
        board[0][6] = new pieces.Knight(Color.BLACK, 0, 6);
        board[7][1] = new pieces.Knight(Color.WHITE, 7, 1);
        board[7][6] = new pieces.Knight(Color.WHITE, 7, 6);

        board[0][2] = new pieces.Bishop(Color.BLACK, 0, 2);
        board[0][5] = new pieces.Bishop(Color.BLACK, 0, 5);
        board[7][2] = new pieces.Bishop(Color.WHITE, 7, 2);
        board[7][5] = new pieces.Bishop(Color.WHITE, 7, 5);

        board[7][3] = new pieces.Queen(Color.WHITE, 7, 3);
        board[0][3] = new pieces.Queen(Color.BLACK, 0, 3);

        board[7][4] = new pieces.King(Color.WHITE, 7, 4);
        board[0][4] = new pieces.King(Color.BLACK, 0, 4);
    }

    public void movePiece(Move move) throws Exception {
        var piece = this.getPiece(move.getLinhaInicial(), move.getColunaInicial());
        if (piece == null) {
            throw new Exception("No Piece in the informed start location");
        }
        if (piece.getColor() != this.currentPlayer) {
            throw new Exception("Its not possible to move your oponent pieces");
        }

        piece.move(move, this);

        var target = this.getPiece(move.getLinhaFinal(), move.getColunaFinal());
        if (target != null) {
            capturedPieces.add(target);
        }

        this.board[move.getLinhaFinal()][move.getColunaFinal()] = piece;
        this.board[move.getLinhaInicial()][move.getColunaInicial()] = null;

        this.changeTurn();
    }
}
