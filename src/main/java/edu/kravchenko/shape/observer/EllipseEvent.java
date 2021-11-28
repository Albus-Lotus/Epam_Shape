package edu.kravchenko.shape.observer;

import edu.kravchenko.shape.entity.Ellipse;

import java.util.EventObject;

public class EllipseEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EllipseEvent(Object source) {
        super(source);
    }

    @Override
    public Ellipse getSource() {
        return (Ellipse) super.getSource();
    }
}
