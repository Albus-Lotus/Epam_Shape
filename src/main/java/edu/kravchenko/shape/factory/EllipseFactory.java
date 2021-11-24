package edu.kravchenko.shape.factory;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final EllipseFactory instance = new EllipseFactory();
    public static final int VALUE_COUNT = 4;

    private EllipseFactory() {
    }

    public Ellipse getEllipse(List<Double> coordinates) throws EllipseException {
        if (coordinates.size() != VALUE_COUNT) {
            logger.log(Level.ERROR, "Invalid arguments count");
            throw new EllipseException("Invalid arguments count");
        }
        Point firstPoint = new Point(coordinates.get(0), coordinates.get(1));
        Point secondPoint = new Point(coordinates.get(2), coordinates.get(3));
        Ellipse ellipse = new Ellipse(firstPoint, secondPoint);
        logger.log(Level.INFO, "Ellipse was created");
        return ellipse;
    }

    public static EllipseFactory getInstance() {
        return instance;
    }
}
