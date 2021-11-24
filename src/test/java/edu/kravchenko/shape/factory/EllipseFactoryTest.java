package edu.kravchenko.shape.factory;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EllipseFactoryTest {
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();

    @Test
    public void createEllipse() throws EllipseException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(-10.0);
        coordinates.add(10.0);
        coordinates.add(30.0);
        coordinates.add(40.0);
        Ellipse ellipse = ellipseFactory.getEllipse(coordinates);
        assertEquals(ellipse, new Ellipse(new Point(-10.0, 10.0), new Point(30.0, 40.0)));
    }
}
