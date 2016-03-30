package com.kazarmax.xo.controllers;

import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import com.kazarmax.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    private static final int CHECK_ROW_MODE = 1;
    private static final int CHECK_COLUMN_MODE = 2;
    private static final int CHECK_MAIN_DIAG_MODE = 3;
    private static final int CHECK_SUB_DIAG_MODE = 4;

    public Figure getWinner(final Field field) {

        if (checkDiags(field) != null) {
            return checkDiags(field);
        } else if (checkLines(field) != null) {
            return checkLines(field);
        }

        return null;

    }

    private Figure checkLines(final Field field) {

        for (int i = 0; i < field.getSize(); i++) {

            if (checkLine(field, i, CHECK_ROW_MODE) != null) {
                return checkLine(field, i, CHECK_ROW_MODE);
            } else if (checkLine(field, i, CHECK_COLUMN_MODE) != null) {
                return checkLine(field, i, CHECK_COLUMN_MODE);
            }

        }

        return null;

    }

    private Figure checkDiags(final Field field) {

        if (checkMainDiag(field) != null) {
            return checkMainDiag(field);
        } else if (checkSubDiag(field) != null) {
            return checkSubDiag(field);
        }

        return null;

    }

    private Figure checkMainDiag(final Field field) {

        return checkLine(field, 0, CHECK_MAIN_DIAG_MODE);

    }

    private Figure checkSubDiag(final Field field) {

        return checkLine(field, 0, CHECK_SUB_DIAG_MODE);

    }

    private Figure checkLine(final Field field, int lineNumber, int mode) {

        Point point = new Point();
        Point nextPoint = new Point();
        Figure returnFigure = null;

        for (int i = 0; i < field.getSize() - 1; i++) {

            if (mode == CHECK_MAIN_DIAG_MODE) {
                point.x = i;
                point.y = i;
                nextPoint.x = i + 1;
                nextPoint.y = i + 1;
            }

            if (mode == CHECK_SUB_DIAG_MODE) {
                point.x = i;
                point.y = field.getSize() - i - 1;
                nextPoint.x = i + 1;
                nextPoint.y = field.getSize() - i - 2;
            }

            if (mode == CHECK_ROW_MODE) {

                point.x = lineNumber;
                point.y = i;
                nextPoint.x = lineNumber;
                nextPoint.y = i + 1;

            }

            if (mode == CHECK_COLUMN_MODE) {

                point.y = lineNumber;
                point.x = i;
                nextPoint.y = lineNumber;
                nextPoint.x = i + 1;

            }

            if (point.equals(nextPoint)) {return null;}

            try {
                if (field.getFigure(point) == null || field.getFigure(point) != field.getFigure(nextPoint)) {
                    return null;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

        }

        try {
            returnFigure = field.getFigure(point);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return returnFigure;

    }

}
