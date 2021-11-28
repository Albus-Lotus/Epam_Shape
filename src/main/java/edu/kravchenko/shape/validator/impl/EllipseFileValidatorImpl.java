package edu.kravchenko.shape.validator.impl;

import edu.kravchenko.shape.validator.EllipseFileValidator;

import java.io.File;

public class EllipseFileValidatorImpl implements EllipseFileValidator {
    private static final String VALID_ELLIPSE_LINE_REGEXP = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";

    public EllipseFileValidatorImpl() {
    }

    @Override
    public boolean isValidFile(String filePath) {
        if (filePath == null) {
            return false;
        }
        File file = new File(filePath);
        return file.isFile() && file.length() != 0;
    }

    @Override
    public boolean isValidLine(String line) {
        return line.matches(VALID_ELLIPSE_LINE_REGEXP);
    }
}
