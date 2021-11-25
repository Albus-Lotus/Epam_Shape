package edu.kravchenko.shape.parser;

import edu.kravchenko.shape.exception.EllipseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class EllipseParserTest {
    private static final EllipseParser ellipseParser = new EllipseParser();
    private static final String VALID_LINE = "-10.0 10.0 30.0 40.0";
    private static final String INVALID_LINE = "-10.0 10.0 30.0 40.0 50.0";
    private static final List<Double> DOUBLE_LIST = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        DOUBLE_LIST.add(-10.0);
        DOUBLE_LIST.add(10.0);
        DOUBLE_LIST.add(30.0);
        DOUBLE_LIST.add(40.0);
    }

    @Test
    public void parseEllipseNullLine() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            ellipseParser.parseEllipse(null);
        });
        String expected = "Line is blank";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void parseEllipse() throws EllipseException {
        List<Double> actual = ellipseParser.parseEllipse(VALID_LINE);

        assertThat(actual).containsExactlyElementsOf(DOUBLE_LIST);
    }

    @Test
    public void parseEllipseInvalidNumberCount() throws EllipseException {
        Exception exception = assertThrows(EllipseException.class, () -> {
            ellipseParser.parseEllipse(INVALID_LINE);
        });
        String expected = "Invalid number count in line";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }
}
