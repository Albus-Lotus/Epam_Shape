package edu.kravchenko.shape.warehouse;

import edu.kravchenko.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer, EllipseParameters> ellipseMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putParameters(int id, double area, double perimeter) {
        EllipseParameters ellipseParameters = new EllipseParameters(area, perimeter);
        ellipseMap.putIfAbsent(id, ellipseParameters);
    }

    public EllipseParameters findParameters(int id) throws EllipseException {
        EllipseParameters ellipseParameters = ellipseMap.get(id);
        if (ellipseParameters == null) {
            throw new EllipseException("No such element in warehouse");
        }
        return ellipseParameters;
    }

    public void updateParameters(int id, double area, double perimeter) throws EllipseException {
        EllipseParameters ellipseParameters = ellipseMap.get(id);
        if (ellipseParameters == null) {
            throw new EllipseException("No such element in warehouse");
        }
        ellipseParameters.setArea(area);
        ellipseParameters.setPerimeter(perimeter);
    }

    public boolean containsKey(int id) {
        return ellipseMap.containsKey(id);
    }
}
