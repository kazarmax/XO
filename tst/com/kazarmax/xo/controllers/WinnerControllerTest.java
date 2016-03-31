package com.kazarmax.xo.controllers;

import com.kazarmax.xo.model.Field;
import com.kazarmax.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenXFillsDiag() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,2), Figure.X);

        final Figure expectedFigure = Figure.X;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenOFillsDiag() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.O);
        field.setFigure(new Point(2,2), Figure.O);

        final Figure expectedFigure = Figure.O;
        final Figure actualFigure;
        actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenXFillsSubDiag() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);

        final Figure expectedFigure = Figure.X;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenOFillsSubDiag() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,2), Figure.O);
        field.setFigure(new Point(1,1), Figure.O);
        field.setFigure(new Point(2,0), Figure.O);

        final Figure expectedFigure = Figure.O;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenXFillsHorLine() throws Exception {

        final Field field = new Field();
        for (int i = 0; i < field.getSize(); i++) {
            final Field field1 = new Field();
            for (int j = 0; j < field.getSize(); j++) {
                field1.setFigure(new Point(i, j), Figure.X);
            }
            assertEquals(Figure.X, new WinnerController().getWinner(field1));
        }
    }

    @Test
    public void testGetWinnerWhenOFillsHorLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.O);

        final Figure expectedFigure = Figure.O;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenXFillsVertLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,0), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);

        final Figure expectedFigure = Figure.X;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenOFillsVertLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(2,0), Figure.O);

        final Figure expectedFigure = Figure.O;
        final Figure actualFigure = new WinnerController().getWinner(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testGetWinnerWhenXNotFillsDiag() throws Exception {

        final Field field = new Field();

        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.O);
        field.setFigure(new Point(2,2), Figure.X);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenONotFillsDiag() throws Exception {

        final Field field = new Field();

        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,2), Figure.O);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenXNotFillsSubDiag() throws Exception {

        final Field field = new Field();

        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenONotFillsSubDiag() throws Exception {

        final Field field = new Field();

        field.setFigure(new Point(0,2), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.O);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenXNotFillsHorLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenONotFillsHorLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(0,1), Figure.X);
        field.setFigure(new Point(0,2), Figure.O);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenXNotFillsVertLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);

        assertNull(new WinnerController().getWinner(field));

    }

    @Test
    public void testGetWinnerWhenONotFillsVertLine() throws Exception {

        final Field field = new Field();
        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,0), Figure.X);
        field.setFigure(new Point(2,0), Figure.O);

        assertNull(new WinnerController().getWinner(field));

    }


}