package edu.kravchenko.shape.validator;

import edu.kravchenko.shape.entity.Point;

public class EllipseParametersValidator {

    public EllipseParametersValidator() {
    }

    public static boolean areValidParameters(Point firstPoint, Point secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            return false;
        }
        return firstPoint.getX() != secondPoint.getX()
                && firstPoint.getY() != secondPoint.getY();
    }
}
