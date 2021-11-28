package edu.kravchenko.shape.repository.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.repository.EllipseSpecification;

public class EllipseIdRangeSpecification implements EllipseSpecification {
    private final int fromId;
    private final int toId;

    public EllipseIdRangeSpecification(int fromId, int toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() >= fromId
                && ellipse.getEllipseId() <= toId;
    }
}
