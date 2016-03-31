package com.kazarmax.xo.controllers;

import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import com.kazarmax.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenFieldIsEmpty() throws Exception {

        Field field = new Field();
        assertEquals(Figure.X, new CurrentMoveController().currentMove(field));

    }

    @Test
    public void testCurrentMoveWhenXEqualsO() throws Exception {

        Field field = new Field();

        try {
            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(0,1), Figure.O);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertEquals(Figure.X, new CurrentMoveController().currentMove(field));

    }

    @Test
    public void testCurrentMoveWhenXGreaterThanO() throws Exception {

        Field field = new Field();

        try {
            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(0,1), Figure.X);
            field.setFigure(new Point(0,2), Figure.O);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertEquals(Figure.O, new CurrentMoveController().currentMove(field));

    }

    @Test
    public void testCurrentMoveWhenOGreaterThanX() throws Exception {

        Field field = new Field();

        try {
            field.setFigure(new Point(0,0), Figure.O);
            field.setFigure(new Point(0,1), Figure.O);
            field.setFigure(new Point(0,2), Figure.X);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertEquals(Figure.X, new CurrentMoveController().currentMove(field));

    }


}