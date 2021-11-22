package edu.kravchenko.shape.reader;

import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.validator.EllipseFileValidator;
import edu.kravchenko.shape.validator.EllipseLineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EllipseFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String filePath) throws EllipseException {
        if (!EllipseFileValidator.isValidFile(filePath)) {
            logger.log(Level.ERROR, "File path represents invalid file");
            throw new EllipseException("File path represents invalid file");
        }
        Path path = Paths.get(filePath);
        List<String> validLines;
        try (Stream<String> validLinesStream = Files.lines(path)) {
            validLines = validLinesStream
                    .filter(EllipseLineValidator::isValidLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file");
            throw new EllipseException("Error while reading file", e);
        }
        if (validLines.size() == 0) {
            logger.log(Level.ERROR, "File does not contain valid lines");
            throw new EllipseException("File does not contain valid lines");
        }
        logger.log(Level.INFO, "Lines were successfully received");
        return validLines;
    }
}
