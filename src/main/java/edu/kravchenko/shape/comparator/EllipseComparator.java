package edu.kravchenko.shape.comparator;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.service.EllipseService;
import edu.kravchenko.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public enum EllipseComparator implements Comparator<Ellipse> {
    ID {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            int result = 0;
            if (o1.getEllipseId() - o2.getEllipseId() < 0) {
                result = -1;
            } else if (o1.getEllipseId() - o2.getEllipseId() > 0) {
                result = 1;
            }
            return result;
        }
    },

    FIRST_POINT_X {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getFirstPoint().getX(), o2.getFirstPoint().getX());
        }
    },

    FIRST_POINT_Y {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getFirstPoint().getY(), o2.getFirstPoint().getY());
        }
    },

    SECOND_POINT_X {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getSecondPoint().getX(), o2.getSecondPoint().getX());
        }
    },

    SECOND_POINT_Y {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getSecondPoint().getY(), o2.getSecondPoint().getY());
        }
    },

    AREA {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            double area1 = 0;
            double area2 = 0;
            try {
                EllipseService ellipseService = new EllipseServiceImpl();
                area1 = ellipseService.calculateArea(o1);
                area2 = ellipseService.calculateArea(o2);
            } catch (EllipseException e) {
                logger.log(Level.ERROR, e);
            }
            return Double.compare(area1, area2);
        }
    },

    PERIMETER {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            double perimeter1 = 0;
            double perimeter2 = 0;
            try {
                EllipseService ellipseService = new EllipseServiceImpl();
                perimeter1 = ellipseService.calculatePerimeter(o1);
                perimeter2 = ellipseService.calculatePerimeter(o2);
            } catch (EllipseException e) {
                logger.log(Level.ERROR, e);
            }
            return Double.compare(perimeter1, perimeter2);
        }
    };

    private static final Logger logger = LogManager.getLogger();
}
