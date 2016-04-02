package com.kazarmax.xo.view;

import com.kazarmax.xo.controllers.CurrentMoveController;
import com.kazarmax.xo.controllers.MoveController;
import com.kazarmax.xo.controllers.WinnerController;
import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import com.kazarmax.xo.model.Game;
import com.kazarmax.xo.model.exceptions.AlreadyOccupiedException;
import com.kazarmax.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final MoveController moveController = new MoveController();
    private final WinnerController winnerController = new WinnerController();

    public void showGameInfo(final Game game) {

        System.out.println("Game name: " + game.getName());

        System.out.println("Players: \n" + " - " + game.getPlayers()[0].getName() + " (figure is \"" +
                game.getPlayers()[0].getFigure() + "\")\n" + " - " +
                game.getPlayers()[1].getName() + " (figure is \"" + game.getPlayers()[1].getFigure() + "\")\n");

    }

    public void showGameField(final Game game) {

        final Field field = game.getField();
        for (int i = 0; i < field.getSize(); i++) {
            printLine(field, i);
            System.out.println();
            if (i != field.getSize() - 1) {
                System.out.println("-----------");
            }
        }
    }

    public boolean move(final Game game) {

        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            if (winnerController.getWinner(field) == null) {
                System.out.println("No winner ... :(((");
                return false;
            }
        } else {
            System.out.println(game.getPlayerByFigure(currentFigure).getName() + ", figure \""
                    + currentFigure + "\". \nPlease enter point for move: ");
            try {
                moveController.applyFigure(field, askPoint(), currentFigure);
            } catch (InvalidPointException | AlreadyOccupiedException e) {
                System.out.println("Invalid coordinates");
                return true;
            }
            if (winnerController.getWinner(field) != null) {
                System.out.println("Move result: ");
                showGameField(game);
                System.out.println();
                System.out.println("*******************************************");
                System.out.println("Congratulations! Winner is: " +
                game.getPlayerByFigure(winnerController.getWinner(field)).getName() + ", figure \""
                        + winnerController.getWinner(field) + "\"");
                System.out.println("*******************************************");
                return false;
            }
        }
        return true;
    }

    private void printLine(final Field field, final int i) {

        for (int j = 0; j < field.getSize(); j++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(i,j));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(" ");
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
            if (j != field.getSize() - 1) {
                System.out.print("|");
            }

        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X"), askCoordinate("Y"));
    }

    private int askCoordinate(final String coordinateName) {
        System.out.print("Input " + coordinateName + ": ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

}
