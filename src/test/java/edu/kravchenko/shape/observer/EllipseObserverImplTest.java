package edu.kravchenko.shape.observer;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.factory.EllipseFactory;
import edu.kravchenko.shape.filler.WarehouseFiller;
import edu.kravchenko.shape.observer.impl.EllipseObserverImpl;
import edu.kravchenko.shape.warehouse.EllipseParameters;
import edu.kravchenko.shape.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class EllipseObserverImplTest {
    private final Warehouse warehouse = Warehouse.getInstance();
    private static Ellipse ellipse;

    @BeforeAll
    public static void setUp() throws EllipseException {
        EllipseFactory ellipseFactory = EllipseFactory.getInstance();
        EllipseObserver observer = new EllipseObserverImpl();
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(-10.0);
        coordinates.add(10.0);
        coordinates.add(30.0);
        coordinates.add(40.0);
        ellipse = ellipseFactory.getEllipse(coordinates);
        ellipse.attach(observer);
        List<Ellipse> ellipses = new ArrayList<>();
        ellipses.add(ellipse);
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        warehouseFiller.fillWarehouse(ellipses);
    }

    @Test
    public void parameterChanged() throws EllipseException {
        int ellipseId = ellipse.getEllipseId();
        EllipseParameters oldParameters = warehouse.findParameters(ellipseId);
        double oldArea = oldParameters.getArea();
        double oldPerimeter = oldParameters.getPerimeter();
        ellipse.setFirstPoint(new Point(-30.0, 0.0));
        EllipseParameters newParameters = warehouse.findParameters(ellipseId);
        double newArea = newParameters.getArea();
        double newPerimeter = newParameters.getPerimeter();
        assertTrue(Double.compare(oldArea, newArea) != 0
                && Double.compare(oldPerimeter, newPerimeter) != 0);

    }
}
