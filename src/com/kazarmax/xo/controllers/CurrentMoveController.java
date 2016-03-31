package com.kazarmax.xo.controllers;

import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import com.kazarmax.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {

        int countX = 0;
        int countO = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {

                try {
                    if (field.getFigure(new Point(i,j)) == Figure.X ) {
                        countX++;
                        continue;
                    }

                    if (field.getFigure(new Point(i,j)) == Figure.O ) {
                        countO++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }

        if ((countX + countO) == field.getSize() * field.getSize()) {
            return null;
        }

        return countX > countO ? Figure.O : Figure.X;

    }



}
