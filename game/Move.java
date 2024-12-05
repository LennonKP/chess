package game;

import java.util.Arrays;

import pieces.Piece;

public class Move {
    private int colunaInicial;
    private int colunaFinal;
    private int linhaInicial;
    private int linhaFinal;

    public int getColunaInicial() {
        return colunaInicial;
    }

    public int getColunaFinal() {
        return colunaFinal;
    }

    public int getLinhaInicial() {
        return linhaInicial;
    }

    public int getLinhaFinal() {
        return linhaFinal;
    }

    public Move(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal) {
        this.linhaInicial = linhaInicial;
        this.colunaInicial = colunaInicial;
        this.linhaFinal = linhaFinal;
        this.colunaFinal = colunaFinal;
    }


    public static Move fromString(String string) throws Exception {
        String[] parts = string.trim().split(" ");
        if (parts.length != 2) {
            throw new Exception("Invalid input format");
        }

        int[] start = Move.parsePosition(parts[0]);
        int[] end = Move.parsePosition(parts[1]);

        var move = new Move(start[0], start[1], end[0], end[1]);
        return move;
    }

    private static int[] parsePosition(String position) throws Exception {
        if (position.length() != 2) {
            throw new Exception("Invalid position format.");
        }

        position = position.toLowerCase();
        var column = position.charAt(0);
        var row = position.charAt(1);

        if (column < 'a' || column > 'h' || row < '1' || row > '8') {
            throw new Exception("Position out of bounds.");
        }

        var colIndex = column - 'a';
        var rowIndex = row - '1';

        return new int[] { rowIndex, colIndex };
    }
}
