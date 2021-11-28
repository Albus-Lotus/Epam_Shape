package edu.kravchenko.shape.filler;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.service.EllipseService;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import edu.kravchenko.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(List<Ellipse> ellipses) {
        Warehouse warehouse = Warehouse.getInstance();
        EllipseService ellipseService = new EllipseServiceImpl();
        for (Ellipse ellipse : ellipses) {
            int ellipseId = ellipse.getEllipseId();
            if (!warehouse.containsKey(ellipseId)) {
                try {
                    double area = ellipseService.calculateArea(ellipse);
                    double perimeter = ellipseService.calculatePerimeter(ellipse);
                    warehouse.putParameters(ellipseId, area, perimeter);
                } catch (EllipseException e) {
                    logger.log(Level.ERROR, e);
                }
            }
        }
    }
}
