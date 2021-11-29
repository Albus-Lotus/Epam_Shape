package edu.kravchenko.shape.repository;

import edu.kravchenko.shape.comparator.EllipseComparator;
import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;
import edu.kravchenko.shape.factory.EllipseFactory;
import edu.kravchenko.shape.observer.EllipseObserver;
import edu.kravchenko.shape.observer.impl.EllipseObserverImpl;
import edu.kravchenko.shape.repository.impl.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class EllipseRepositoryTest {
    EllipseRepository repository = EllipseRepository.getInstance();
    private static Ellipse ellipse1;
    private static Ellipse ellipse2;

    @BeforeAll
    public static void setUp() throws EllipseException {
        EllipseFactory ellipseFactory = EllipseFactory.getInstance();
        EllipseObserver observer = new EllipseObserverImpl();
        List<Double> coordinates1 = new ArrayList<>();
        coordinates1.add(-10.0);
        coordinates1.add(10.0);
        coordinates1.add(30.0);
        coordinates1.add(40.0);
        ellipse1 = ellipseFactory.getEllipse(coordinates1);
        ellipse1.attach(observer);
        List<Ellipse> ellipses = new ArrayList<>();
        ellipses.add(ellipse1);
        List<Double> coordinates2 = new ArrayList<>();
        coordinates2.add(-30.0);
        coordinates2.add(-10.0);
        coordinates2.add(0.0);
        coordinates2.add(-60.0);
        ellipse2 = ellipseFactory.getEllipse(coordinates2);
        ellipse2.attach(observer);
    }

    @Test
    public void size() {
        repository.clear();
        repository.add(ellipse1);
        int expected = 1;
        int actual = repository.size();
        assertEquals(expected, actual);
    }

    @Test
    public void containsTrue() {
        repository.clear();
        repository.add(ellipse1);
        assertTrue(repository.contains(ellipse1));
    }

    @Test
    public void containsFalse() {
        repository.clear();
        repository.add(ellipse1);
        assertFalse(repository.contains(ellipse2));
    }

    @Test
    public void add() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        int expected = 2;
        int actual = repository.size();
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        repository.remove(ellipse1);
        assertFalse(repository.contains(ellipse1));
    }

    @Test
    public void isEmptyTrue() {
        repository.clear();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void isEmptyFalse() {
        repository.clear();
        repository.add(ellipse1);
        assertFalse(repository.isEmpty());
    }

    @Test
    public void getInvalidIndex() throws EllipseException{
        Exception exception = assertThrows(EllipseException.class, () -> {
            repository.get(3);
        });
        String expected = "Invalid index";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void get() throws EllipseException {
        repository.clear();
        repository.add(ellipse1);
        Ellipse expected = ellipse1;
        Ellipse actual = repository.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void set() throws EllipseException {
        repository.clear();
        repository.add(ellipse1);
        repository.set(0, ellipse2);
        Ellipse expected = ellipse2;
        Ellipse actual = repository.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void sortById() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse1);
        expected.add(ellipse2);
        EllipseComparator comparator = EllipseComparator.ID;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortByFirstPointX() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        expected.add(ellipse1);
        EllipseComparator comparator = EllipseComparator.FIRST_POINT_X;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortByFirstPointY() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        expected.add(ellipse1);
        EllipseComparator comparator = EllipseComparator.FIRST_POINT_Y;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortBySecondPointX() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        expected.add(ellipse1);
        EllipseComparator comparator = EllipseComparator.SECOND_POINT_X;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortBySecondPointY() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        expected.add(ellipse1);
        EllipseComparator comparator = EllipseComparator.SECOND_POINT_Y;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortByArea() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse1);
        expected.add(ellipse2);
        EllipseComparator comparator = EllipseComparator.AREA;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortByPerimeter() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse1);
        expected.add(ellipse2);
        EllipseComparator comparator = EllipseComparator.PERIMETER;
        List<Ellipse> actual = repository.sort(comparator);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void querySpecificationIdRange() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        EllipseSpecification specification =
                new EllipseIdRangeSpecification(ellipse2.getEllipseId(), ellipse2.getEllipseId() + 3);
        List<Ellipse> actual = repository.query(specification);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void querySpecificationMaxWidth() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        EllipseSpecification specification =
                new EllipseMaxWidthSpecification(30.0);
        List<Ellipse> actual = repository.query(specification);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void querySpecificationMinHeight() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse2);
        EllipseSpecification specification =
                new EllipseMinHeightSpecification(40.0);
        List<Ellipse> actual = repository.query(specification);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void querySpecificationAreaRange() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        EllipseSpecification specification =
                new EllipseAreaRangeSpecification(0, 500);
        List<Ellipse> actual = repository.query(specification);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void querySpecificationPerimeterTest() {
        repository.clear();
        repository.add(ellipse1);
        repository.add(ellipse2);
        List<Ellipse> expected = new ArrayList<>();
        expected.add(ellipse1);
        EllipseSpecification specification =
                new EllipsePerimeterRangeSpecification(100, 115);
        List<Ellipse> actual = repository.query(specification);

        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
