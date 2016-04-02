package com.kazarmax.xo;

import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import com.kazarmax.xo.model.Game;
import com.kazarmax.xo.model.Player;
import com.kazarmax.xo.view.ConsoleView;

import java.util.Scanner;

public class XOCLI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input name of first player: ");
        final String player1Name = scanner.next();
        System.out.print("Please input name of second player: ");
        final String player2Name = scanner.next();
        System.out.println();

        final Player[] players = new Player[2];
        players[0] = new Player(player1Name, Figure.X);
        players[1] = new Player(player2Name, Figure.O);

        final Game game = new Game(players, new Field(), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.showGameInfo(game);
        System.out.println("Initial game field:");
        consoleView.showGameField(game);
        System.out.println();
        while (consoleView.move(game)) {
            System.out.println("Move result: ");
            consoleView.showGameField(game);
            System.out.println();
            System.out.println("****************************");
        }

    }


}
