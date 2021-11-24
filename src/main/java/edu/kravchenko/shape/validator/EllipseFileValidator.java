package edu.kravchenko.shape.validator;

import java.io.File;

public interface EllipseFileValidator {

    boolean isValidFile(String filePath);

    boolean isValidLine(String line);
}
