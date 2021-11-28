package edu.kravchenko.shape.entity;

import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.observer.EllipseEvent;
import edu.kravchenko.shape.observer.EllipseObservable;
import edu.kravchenko.shape.observer.EllipseObserver;
import edu.kravchenko.shape.util.IdGenerator;
import edu.kravchenko.shape.validator.EllipseParametersValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.kravchenko.shape.validator.impl.EllipseParametersValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ellipse implements EllipseObservable {
    private static final Logger logger = LogManager.getLogger();
    private final int ellipseId;
    private Point firstPoint;
    private Point secondPoint;
    private final List<EllipseObserver> observers = new ArrayList<>();

    public Ellipse() {
        firstPoint = new Point();
        secondPoint = new Point();
        ellipseId = IdGenerator.generateId();
    }

    public Ellipse(Point firstPoint, Point secondPoint) throws EllipseException {
        EllipseParametersValidatorImpl ellipseParametersValidator = new EllipseParametersValidatorImpl();
        if (!ellipseParametersValidator.areValidParameters(firstPoint, secondPoint)) {
            throw new EllipseException("Invalid arguments: " + firstPoint + " " + secondPoint);
        }
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        ellipseId = IdGenerator.generateId();
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
        notifyObservers();
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
        notifyObservers();
    }

    public int getEllipseId() {
        return ellipseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse ellipse = (Ellipse) o;
        return Objects.equals(getFirstPoint(), ellipse.getFirstPoint())
                && Objects.equals(getSecondPoint(), ellipse.getSecondPoint());
    }

    @Override
    public int hashCode() {
        int result = ellipseId;
        result = 31 * result + (firstPoint != null ? firstPoint.hashCode() : 0);
        result = 31 * result + (secondPoint != null ? secondPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("id=").append(ellipseId);
        sb.append(", firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void attach(EllipseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(EllipseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (EllipseObserver observer : observers) {
            if (observer != null) {
                EllipseEvent event = new EllipseEvent(this);
                observer.parameterChanged(event);
            }
        }
    }
}
