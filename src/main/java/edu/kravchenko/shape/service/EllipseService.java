package edu.kravchenko.shape.service;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;

public interface EllipseService {

    double calculateArea(Ellipse ellipse) throws EllipseException;

    double calculatePerimeter(Ellipse ellipse) throws EllipseException;

    boolean isValidOval(Ellipse ellipse) throws EllipseException;

    boolean isCrossAxisByDistance(Ellipse ellipse, double distance) throws EllipseException;

    boolean isOval(Ellipse ellipse) throws EllipseException;

    boolean isCircle(Ellipse ellipse) throws EllipseException;
}
