package edu.kravchenko.shape.observer.impl;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.observer.EllipseEvent;
import edu.kravchenko.shape.observer.EllipseObserver;
import edu.kravchenko.shape.service.EllipseService;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import edu.kravchenko.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserverImpl implements EllipseObserver {
    private static final Logger logger = LogManager.getLogger();

    public EllipseObserverImpl() {
    }

    @Override
    public void parameterChanged(EllipseEvent event) {
        Warehouse warehouse = Warehouse.getInstance();
        EllipseService ellipseService = new EllipseServiceImpl();
        Ellipse ellipse = event.getSource();
        int ellipseId = ellipse.getEllipseId();
        try {
            double area = ellipseService.calculateArea(ellipse);
            double perimeter = ellipseService.calculatePerimeter(ellipse);
            warehouse.updateParameters(ellipseId, area, perimeter);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, "Error while updating warehouse");
        }
    }
}
