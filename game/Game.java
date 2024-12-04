package game;

import java.util.Scanner;

public class Game {
    private Scanner sc;
    private Board board;

    public Game() {
        this.sc = new Scanner(System.in);
        this.board = new Board();
        this.start();
    }

    public void start() {
        while (!this.board.isGameOver()) {
            System.out.println(this.board.getCurrentPlayer() + "'s turn");
            while (true) {
                try {
                    var input = sc.nextLine();
                    var move = Move.fromString(input);
                    move.exec(this.board);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid move: " + e.getMessage());
                    System.out.println("Try Again...");
                }
            }

            this.board.print();
        }
    }

}
