package edu.kravchenko.shape.factory;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EllipseFactoryTest {
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static final List<Double> DOUBLE_LIST = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        DOUBLE_LIST.add(-10.0);
        DOUBLE_LIST.add(10.0);
        DOUBLE_LIST.add(30.0);
        DOUBLE_LIST.add(40.0);
    }

    @Test
    public void createEllipse() throws EllipseException {
        Ellipse expected = new Ellipse(new Point(DOUBLE_LIST.get(0), DOUBLE_LIST.get(1)),
                new Point(DOUBLE_LIST.get(2), DOUBLE_LIST.get(3)));
        Ellipse actual = ellipseFactory.getEllipse(DOUBLE_LIST);

        assertEquals(expected, actual);
    }

    @Test
    public void createEllipseInvalidArgumentsCount() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            DOUBLE_LIST.add(50.0);
            Ellipse ellipse = ellipseFactory.getEllipse(DOUBLE_LIST);
        });
        String expected = "Invalid arguments count";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }
}
