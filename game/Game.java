package game;

import java.util.Scanner;

public class Game {
    private Scanner sc;
    private Board board;

    public Game() {
        this.sc = new Scanner(System.in);
        this.start();
    }

    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            this.board = new Board();
            System.out.println("New game started!");
            while (this.board.getWinner() == null) {
                System.out.println(this.board.getCurrentPlayer() + "'s turn");
                while (true) {
                    try {
                        var input = sc.nextLine();
                        var move = Move.fromString(input);
                        this.board.movePiece(move);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid move: " + e.getMessage());
                        System.out.println("Try Again...");
                    }
                }

                this.board.print();
            }

            System.out.println("Play again? (y/n)");
            playAgain = sc.nextLine().trim().equalsIgnoreCase("y");
        }
        System.out.println("Thanks for playing!");
    }

}
