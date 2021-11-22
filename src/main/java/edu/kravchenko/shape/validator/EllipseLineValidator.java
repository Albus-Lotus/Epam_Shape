package edu.kravchenko.shape.validator;

public class EllipseLineValidator {
    private static final String VALID_ELLIPSE_LINE_REGEXP = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";

    private EllipseLineValidator() {
    }

    public static boolean isValidLine(String line) {
        return line.matches(VALID_ELLIPSE_LINE_REGEXP);
    }
}
