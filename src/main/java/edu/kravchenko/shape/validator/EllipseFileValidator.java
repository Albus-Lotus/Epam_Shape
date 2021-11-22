package edu.kravchenko.shape.validator;

import java.io.File;

public class EllipseFileValidator {

    private EllipseFileValidator() {
    }

    public static boolean isValidFile(String filePath) {
        if (filePath == null) {
            return false;
        }
        File file = new File(filePath);
        return file.isFile() && file.length() != 0;
    }
}
