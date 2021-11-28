package edu.kravchenko.shape.service;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.factory.EllipseFactory;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseServiceImplTest {
    private final EllipseService ellipseService = new EllipseServiceImpl();
    private final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static final List<Double> ELLIPSE_COORDS = new ArrayList<>();
    private static final List<Double> CIRCLE_COORDS = new ArrayList<>();

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
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);
        Double expected = 942.4778;
        Double actual = ellipseService.calculateArea(ellipse);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculatePerimeter() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);
        Double expected = 111.0721;
        Double actual = ellipseService.calculatePerimeter(ellipse);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculatePerimeterNotRight() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);
        Double expected = 100.1456;
        Double actual = ellipseService.calculatePerimeter(ellipse);

        assertNotEquals(expected, actual, 0.0001);
    }

    @Test
    public void isValidOvalTrue() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);

        assertTrue(ellipseService.isValidOval(ellipse));
    }

    @Test
    public void isValidOvalFalse() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);
        ellipse.setSecondPoint(new Point(-10.0, 40.0));
        ellipseService.isValidOval(ellipse);

        assertFalse(ellipseService.isValidOval(ellipse));
    }

    @Test
    public void isCrossAxisByDistanceTrue() throws EllipseException {
        Double distance = 10.0;
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);

        assertTrue(ellipseService.isCrossAxisByDistance(ellipse, distance));
    }

    @Test
    public void isCrossAxisByDistanceFalse() throws EllipseException {
        Double distance = 50.0;
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);

        assertFalse(ellipseService.isCrossAxisByDistance(ellipse, distance));
    }

    @Test
    public void isOvalTrue() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);

        assertTrue(ellipseService.isOval(ellipse));
    }

    @Test
    public void isOvalFalse() throws EllipseException {
        Ellipse circle = ellipseFactory.getEllipse(CIRCLE_COORDS);

        assertFalse(ellipseService.isOval(circle));
    }

    @Test
    public void isCircleTrue() throws EllipseException {
        Ellipse circle = ellipseFactory.getEllipse(CIRCLE_COORDS);

        assertTrue(ellipseService.isCircle(circle));
    }

    @Test
    public void isCircleFalse() throws EllipseException {
        Ellipse ellipse = ellipseFactory.getEllipse(ELLIPSE_COORDS);

        assertFalse(ellipseService.isCircle(ellipse));
    }

}
