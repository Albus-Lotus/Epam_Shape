package edu.kravchenko.shape.reader;

import edu.kravchenko.shape.exception.EllipseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EllipseFileReaderTest {
    private final EllipseFileReader ellipseFileReader = new EllipseFileReader();
    private static final List<String> LINE_LIST = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        LINE_LIST.add("10.0 10.0 30.0 30.0");
        LINE_LIST.add("-10.0 -30.0 40.0 30.0");
    }

    @Test
    public void readNullFile() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            ellipseFileReader.readFile(null);
        });
        String expected = "File path represents invalid file";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void readFile() throws EllipseException {
        File file = new File(getClass().getClassLoader().getResource("files/ellipse_data.txt").getFile());
        String path = file.getAbsolutePath();
        List<String> actual = ellipseFileReader.readFile(path);

        assertThat(actual).containsExactlyElementsOf(LINE_LIST);
    }
}
