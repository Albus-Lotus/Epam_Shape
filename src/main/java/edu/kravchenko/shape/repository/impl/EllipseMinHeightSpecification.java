package edu.kravchenko.shape.repository.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.repository.EllipseSpecification;

public class EllipseMinHeightSpecification implements EllipseSpecification {
    private final double minHeight;

    public EllipseMinHeightSpecification(double minHeight) {
        this.minHeight = minHeight;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double height = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());
        return height >= minHeight;
    }
}
