package edu.kravchenko.shape.repository.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.repository.EllipseSpecification;
import edu.kravchenko.shape.service.EllipseService;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipsePerimeterRangeSpecification implements EllipseSpecification {
    private static final Logger logger = LogManager.getLogger();
    private final double fromPerimeter;
    private final double toPerimeter;

    public EllipsePerimeterRangeSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double perimeter = 0;
        try {
            EllipseService ellipseService = new EllipseServiceImpl();
            perimeter = ellipseService.calculatePerimeter(ellipse);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        return Double.compare(fromPerimeter, perimeter) <= 0
                && Double.compare(perimeter, toPerimeter) <= 0;
    }
}
