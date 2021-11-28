package edu.kravchenko.shape.reader;

import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.validator.EllipseFileValidator;
import edu.kravchenko.shape.validator.impl.EllipseFileValidatorImpl;
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
        EllipseFileValidator ellipseFileValidator = new EllipseFileValidatorImpl();
        if (!ellipseFileValidator.isValidFile(filePath)) {
            throw new EllipseException("File path represents invalid file");
        }
        Path path = Paths.get(filePath);
        List<String> validLines;
        try (Stream<String> validLinesStream = Files.lines(path)) {
            validLines = validLinesStream
                    .filter(ellipseFileValidator::isValidLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new EllipseException("Error while reading file" + filePath, e);
        }
        logger.log(Level.INFO, "Lines were successfully received");
        return validLines;
    }
}
