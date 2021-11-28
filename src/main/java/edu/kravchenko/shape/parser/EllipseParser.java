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

    public List<Double> parseEllipse(String line) throws EllipseException {
        if (line == null || line.isBlank()) {
            throw new EllipseException("Line is blank");
        }
        List<Double> valueList;
        try {
            valueList = Arrays.stream(line.split(SPACE_REGEXP))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new EllipseException("Error while parsing double", e);
        }
        if (valueList.size() != VALUE_COUNT) {
            throw new EllipseException("Invalid number count in line");
        }
        logger.log(Level.INFO, "Line were successfully parsed");
        return valueList;
    }
}
