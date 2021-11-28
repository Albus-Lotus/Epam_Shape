package edu.kravchenko.shape.repository.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.repository.EllipseSpecification;

public class EllipseMaxWidthSpecification implements EllipseSpecification {
    private final int maxWidth;

    public EllipseMaxWidthSpecification(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double width = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
        return width <= maxWidth;
    }
}
