package edu.kravchenko.shape.service;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseServiceImplTest {
    private static final EllipseService ellipseService = new EllipseServiceImpl();
    private static final List<Double> ELLIPSE_COORDS = new ArrayList<>();
    private static final List<Double> CIRCLE_COORDS = new ArrayList<>();
    private static final List<Double> INVALID_ELLIPSE_COORDS = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        ELLIPSE_COORDS.add(-10.0);
        ELLIPSE_COORDS.add(10.0);
        ELLIPSE_COORDS.add(30.0);
        ELLIPSE_COORDS.add(40.0);
        CIRCLE_COORDS.add(30.0);
        CIRCLE_COORDS.add(50.0);
        CIRCLE_COORDS.add(40.0);
        CIRCLE_COORDS.add(40.0);
        INVALID_ELLIPSE_COORDS.add(-30.0);
        INVALID_ELLIPSE_COORDS.add(10.0);
        INVALID_ELLIPSE_COORDS.add(-10.0);
        INVALID_ELLIPSE_COORDS.add(10.0);
    }

    @Test
    public void calculateAreaNullEllipse() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            ellipseService.calculateArea(null);
        });
        String expected = "Ellipse is null";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void calculateArea() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));
        Double expected = 942.4778;
        Double actual = ellipseService.calculateArea(ellipse);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculatePerimeter() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));
        Double expected = 111.0721;
        Double actual = ellipseService.calculatePerimeter(ellipse);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculatePerimeterNotRight() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));
        Double expected = 100.1456;
        Double actual = ellipseService.calculatePerimeter(ellipse);

        assertNotEquals(expected, actual, 0.0001);
    }

    @Test
    public void isValidOvalTrue() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));

        assertTrue(ellipseService.isValidOval(ellipse));
    }

    @Test
    public void isValidOvalFalse() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            Ellipse invalidEllipse = new Ellipse(new Point(INVALID_ELLIPSE_COORDS.get(0), INVALID_ELLIPSE_COORDS.get(1)),
                    new Point(INVALID_ELLIPSE_COORDS.get(2), INVALID_ELLIPSE_COORDS.get(3)));
            ellipseService.isValidOval(invalidEllipse);
        });
        String expected = "Invalid arguments";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void isCrossAxisByDistanceTrue() throws EllipseException {
        Double distance = 10.0;
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));

        assertTrue(ellipseService.isCrossAxisByDistance(ellipse, distance));
    }

    @Test
    public void isCrossAxisByDistanceFalse() throws EllipseException {
        Double distance = 50.0;
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));

        assertFalse(ellipseService.isCrossAxisByDistance(ellipse, distance));
    }

    @Test
    public void isOvalTrue() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));

        assertTrue(ellipseService.isOval(ellipse));
    }

    @Test
    public void isOvalFalse() throws EllipseException {
        Ellipse circle = new Ellipse(new Point(CIRCLE_COORDS.get(0), CIRCLE_COORDS.get(1)),
                new Point(CIRCLE_COORDS.get(2), CIRCLE_COORDS.get(3)));

        assertFalse(ellipseService.isOval(circle));
    }

    @Test
    public void isCircleTrue() throws EllipseException {
        Ellipse circle = new Ellipse(new Point(CIRCLE_COORDS.get(0), CIRCLE_COORDS.get(1)),
                new Point(CIRCLE_COORDS.get(2), CIRCLE_COORDS.get(3)));

        assertTrue(ellipseService.isCircle(circle));
    }

    @Test
    public void isCircleFalse() throws EllipseException {
        Ellipse ellipse = new Ellipse(new Point(ELLIPSE_COORDS.get(0), ELLIPSE_COORDS.get(1)),
                new Point(ELLIPSE_COORDS.get(2), ELLIPSE_COORDS.get(3)));

        assertFalse(ellipseService.isCircle(ellipse));
    }

}
