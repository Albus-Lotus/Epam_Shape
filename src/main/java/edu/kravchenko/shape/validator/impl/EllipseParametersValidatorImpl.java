package edu.kravchenko.shape.validator.impl;

import edu.kravchenko.shape.entity.Point;
import edu.kravchenko.shape.validator.EllipseParametersValidator;

public class EllipseParametersValidatorImpl implements EllipseParametersValidator {

    @Override
    public boolean areValidParameters(Point firstPoint, Point secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            return false;
        }
        return firstPoint.getX() != secondPoint.getX()
                && firstPoint.getY() != secondPoint.getY();
    }
}
