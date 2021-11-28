package edu.kravchenko.shape.filler;

import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.repository.EllipseRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RepositoryFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillRepository(List<Ellipse> ellipses) {
        EllipseRepository ellipseRepository = EllipseRepository.getInstance();
        for (Ellipse ellipse : ellipses) {
            ellipseRepository.add(ellipse);
        }
        logger.log(Level.INFO, "Repository were successfully filled");
    }
}
