package edu.kravchenko.shape.service.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.service.EllipseService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseServiceImpl implements EllipseService {
    private static final Logger logger = LogManager.getLogger();
    private static final String ELLIPSE_IS_NULL_ERROR_MESSAGE = "Ellipse is null";

    @Override
    public double calculateArea(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double a = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double b = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        double area = Math.PI * a * b;
        logger.log(Level.INFO, "Area is {}", area);
        return area;
    }

    @Override
    public double calculatePerimeter(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double a = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double b = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        double perimeter = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
        logger.log(Level.INFO, "Perimeter is {}", perimeter);
        return perimeter;
    }

    @Override
    public boolean isValidOval(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        boolean result = firstPoint.getX() != secondPoint.getX()
                && secondPoint.getY() != secondPoint.getY();
        logger.log(Level.INFO, "Is oval valid: {}", result);
        return result;
    }

    @Override
    public boolean isCrossAxisByDistance(Ellipse ellipse, double distance) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        boolean crossAxisX = false;
        boolean crossAxisY = false;
        if (firstPoint.getX() * secondPoint.getX() < 0) {
            crossAxisX = Math.abs(firstPoint.getX()) == distance
                    || Math.abs(secondPoint.getX()) == distance;
        }
        if (firstPoint.getY() * secondPoint.getY() < 0) {
            crossAxisY = Math.abs(firstPoint.getY()) == distance
                    || Math.abs(secondPoint.getY()) == distance;
        }
        return crossAxisX ^ crossAxisY;
    }

    @Override
    public boolean isOval(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double width = Math.abs(firstPoint.getX() - secondPoint.getX());
        double height = Math.abs(firstPoint.getY() - secondPoint.getY());
        boolean result = Double.compare(width, height) != 0;
        logger.log(Level.INFO, "Is oval: {}", result);
        return result;
    }

    @Override
    public boolean isCircle(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, ELLIPSE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(ELLIPSE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double width = Math.abs(firstPoint.getX() - secondPoint.getX());
        double height = Math.abs(firstPoint.getY() - secondPoint.getY());
        boolean result = Double.compare(width, height) == 0;
        logger.log(Level.INFO, "Is circle: {}", result);
        return result;
    }
}
