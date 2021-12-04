package ua.ithillel.current;

import java.util.Scanner;

public class TicTacToe {

    public void start() {
        Field field = new Field();
        Move playerMoveAction = new PlayerMove(field);
        Move aiMoveAction = new AIMove(field);
        field.initField();
        do {
            field.printField();
            if (field.checkWinner(field.doMove(playerMoveAction))) {
                System.out.println("You win!");
                break;
            }
            if (field.checkWinner(field.doMove(aiMoveAction))) {
                System.out.println("Ai win!");
                break;
            }
            if (field.isFreeField()) {
                System.out.println("Draw");
                break;
            }
        } while (true);
        field.printField();
        ticTacToeMenu();
    }

    private void ticTacToeMenu() {
        System.out.println("Do you want to play again?");
        System.out.println("Choice: 1.Play again, q.Exit");
        String choice;
        Scanner scan = new Scanner(System.in);
        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1":
                    start();
                case "2":
                    choice = "q";
            }
        } while (!choice.equals("q"));
    }
}