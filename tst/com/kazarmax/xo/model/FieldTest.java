package com.kazarmax.xo.model;

import com.kazarmax.xo.model.exceptions.AlreadyOccupiedException;
import com.kazarmax.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}

    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);

    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXAndYAreLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXIsMoreThanSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(4,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsMoreThanSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,4);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXAndYAreMoreThanSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(4,4);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {}

    }

}