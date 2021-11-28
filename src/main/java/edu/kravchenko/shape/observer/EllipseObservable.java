package edu.kravchenko.shape.observer;

public interface EllipseObservable {
    void attach(EllipseObserver observer);

    void detach(EllipseObserver observer);

    void notifyObservers();
}
