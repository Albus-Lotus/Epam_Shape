package edu.kravchenko.shape.parser;

import edu.kravchenko.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static edu.kravchenko.shape.factory.EllipseFactory.VALUE_COUNT;

public class EllipseParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_REGEXP = "\\s+";

    public List<Double> parseEllipse(String ellipseLine) throws EllipseException {
        if (ellipseLine == null || ellipseLine.isBlank()) {
            logger.log(Level.ERROR, "Line is blank");
            throw new EllipseException("line is blank");
        }
        List<Double> valueList;
        try {
            valueList = Arrays.stream(ellipseLine.split(SPACE_REGEXP))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, "Error while parsing double");
            throw new EllipseException("Error while parsing double", e);
        }
        if (valueList.size() != VALUE_COUNT) {
            logger.log(Level.ERROR, "Invalid number count in line");
            throw new EllipseException("Invalid number count in line");
        }
        logger.log(Level.INFO, "Line were successfully parsed");
        return valueList;
    }
}
