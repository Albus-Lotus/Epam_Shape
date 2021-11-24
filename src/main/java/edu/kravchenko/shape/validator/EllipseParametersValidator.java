package edu.kravchenko.shape.validator;

import edu.kravchenko.shape.entity.Point;

public interface EllipseParametersValidator {

    boolean areValidParameters(Point firstPoint, Point secondPoint);
}
