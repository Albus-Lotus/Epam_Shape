package edu.kravchenko.shape.repository.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.repository.EllipseSpecification;
import edu.kravchenko.shape.service.EllipseService;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseAreaRangeSpecification implements EllipseSpecification {
    private static final Logger logger = LogManager.getLogger();
    private final double fromArea;
    private final double toArea;

    public EllipseAreaRangeSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double area = 0;
        try {
            EllipseService ellipseService = new EllipseServiceImpl();
            area = ellipseService.calculateArea(ellipse);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        return Double.compare(fromArea, area) <= 0
                && Double.compare(area, toArea) <= 0;
    }
}
